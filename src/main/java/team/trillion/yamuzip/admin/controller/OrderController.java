package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.admin.model.dto.OrderDTO;
import team.trillion.yamuzip.admin.model.dto.OrderDetailDTO;
import team.trillion.yamuzip.admin.model.service.OrderService;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
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


}
