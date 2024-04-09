package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.admin.model.dto.OrderDTO;
import team.trillion.yamuzip.admin.model.dto.OrderDetailDTO;
import team.trillion.yamuzip.admin.model.service.OrderService;
import team.trillion.yamuzip.order.model.dto.OrderCancelDTO;
import team.trillion.yamuzip.order.model.dto.PaymentDTO;
import team.trillion.yamuzip.order.model.service.PaymentService;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin/order")
public class OrderController {

    private final OrderService orderService;
    private final PaymentService paymentService;

    public OrderController(OrderService orderService, PaymentService paymentService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    @GetMapping("/list")
    public String getOrderList(@RequestParam(defaultValue = "1") int page,
                                 Model model) {
        Map<String, Object> orderListAndPaging = orderService.getOrderList(page);
        model.addAttribute("paging", orderListAndPaging.get("paging"));

        List<OrderDTO> orderList = (List<OrderDTO>) orderListAndPaging.get("orderList");
        for(OrderDTO order : orderList) {
            order.setOrderDateString(order.getOrderDatetime().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        model.addAttribute("orderList", orderList);

        return "admin/order/list";
    }

    @GetMapping("/detail")
    public String getOrderDetail(@RequestParam int orderCode,
                                 Model model) {
        OrderDetailDTO orderDetail = orderService.selectOrderDetail(orderCode);

        orderDetail.setOrderDateString(orderDetail.getOrderDatetime()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        orderDetail.setReserveDateString(orderDetail.getReserveDatetime()
                .format(DateTimeFormatter.ISO_LOCAL_DATE));

        if(orderDetail.getRejectDatetime() != null) {
            orderDetail.setRejectDateString(orderDetail.getRejectDatetime()
                    .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        }
        if(orderDetail.getCancelDatetime() != null) {
            orderDetail.setCancelDateString(orderDetail.getCancelDatetime()
                    .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        }

        model.addAttribute("orderDetail", orderDetail);

        return "admin/order/detail";
    }

    @PostMapping("/cancel")
    public String cancelOrder(@RequestParam int orderCode,
                              @RequestParam String cancelReason,
                              @RequestParam(required = false) String cancelReasonEtc) throws IOException {

        String token = paymentService.getToken();
        PaymentDTO payment = paymentService.getPaymentByOrderCode(orderCode);
        String reason = cancelReasonEtc != null ? cancelReasonEtc : cancelReason;

        OrderCancelDTO orderCancel = new OrderCancelDTO();
        orderCancel.setPayCode(payment.getPayCode());
        orderCancel.setOrderCode(orderCode);
        orderCancel.setCancelReason(reason);

        paymentService.cancelOrder(token, orderCancel);

        return "admin/order/detail";
    }


}
