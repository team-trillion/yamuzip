package team.trillion.yamuzip.order.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.trillion.yamuzip.common.exception.OrderFailedException;
import team.trillion.yamuzip.order.model.dto.*;
import team.trillion.yamuzip.order.model.service.OrderService;
import team.trillion.yamuzip.order.model.service.PaymentService;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final PaymentService paymentService;

    @GetMapping("")
    public String getOrderPage(@RequestParam int serviceCode, Model model) {
        ServiceDTO service = orderService.selectService(serviceCode);

        // 도비 영업일 Set
        Set<Integer> dobWeekday = new HashSet<>();
        if(!service.getDobby().getWorkdayList().isEmpty()) {
            service.getDobby().getWorkdayList().forEach( workdayDTO -> {
                dobWeekday.add(workdayDTO.getDayWeek());
            });
        }

        // 이미 예약된 날짜 Set
        Set<String> disabledDates = new HashSet<>();
        if(!service.getOrderList().isEmpty()) {
            service.getOrderList().forEach( orderDTO -> {
                String datetime = orderDTO.getReserveDatetime().toString();
                String date = datetime.split("T")[0];
                disabledDates.add(date);
            });
        }

        model.addAttribute("service", service);
        model.addAttribute("disabledDates", disabledDates);
        model.addAttribute("dobWeekday", dobWeekday);
        return "order/order";
    }

    @GetMapping("/payment")
    public String makePayment(@RequestParam int serviceCode,
                              @RequestParam String reserveDatetime,
                              @RequestParam(required = false, defaultValue = "0") int optionCode,
                              Model model) {

        ServiceDTO service = orderService.selectService(serviceCode);
        OptionDTO option = (optionCode == 0) ? null : orderService.selectOption(optionCode);

        int totalPrice = (option == null) ? service.getServicePrice() :
                                            service.getServicePrice() + option.getOptionPrice();

        model.addAttribute("service", service);
        model.addAttribute("option", option);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("reserveDatetime", reserveDatetime);

        return "order/payment";
    }

    @PostMapping("/payment")
    public ResponseEntity<String> insertOrderAndPayment(@RequestBody OrderPaymentDTO orderPayment) throws OrderFailedException {

        OrderDTO order = new OrderDTO();
        order.setServiceCode(orderPayment.getServiceCode());
        order.setUserCode(orderPayment.getUserCode());
        order.setTotalPrice(orderPayment.getTotalPrice());
        order.setReserveDatetime(orderPayment.getReserveDatetime());
        order.setOptionCode(orderPayment.getOptionCode());

        PaymentDTO payment = new PaymentDTO();
        payment.setPayCode(orderPayment.getPayCode());
        payment.setPayPrice(orderPayment.getTotalPrice());
        payment.setPayType(orderPayment.getPayType());
        payment.setPayStatus(orderPayment.getPayStatus());
        payment.setPayDatetime(orderPayment.getPayDatetime());

        orderService.insertOrderInfo(order, payment);

        return ResponseEntity.ok("/order/success");
    }

    @GetMapping("/success")
    public String orderSuccess (@RequestParam String payCode, Model model) {
        OrderResultDTO orderResult = orderService.selectOrderResult(payCode);

        model.addAttribute("orderResult", orderResult);

        return "order/success";
    }

    @GetMapping("/error")
    public void orderErrorView() {}

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

        return "redirect:/mypage/order";
    }
}
