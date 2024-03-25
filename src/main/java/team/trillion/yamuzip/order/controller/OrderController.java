package team.trillion.yamuzip.order.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import team.trillion.yamuzip.order.model.dto.*;
import team.trillion.yamuzip.order.model.service.OrderService;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

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
    public ResponseEntity<String> insertOrderAndPayment(@RequestBody OrderPaymentDTO orderPayment) {

        OrderDTO order = new OrderDTO();
        order.setServiceCode(orderPayment.getServiceCode());
        order.setUserCode(orderPayment.getUserCode());
        order.setTotalPrice(orderPayment.getTotalPrice());
        order.setReserveDatetime(orderPayment.getReserveDatetime());
        order.setOptionCode(orderPayment.getOptionCode());

        int orderCode = orderService.insertOrder(order).getOrderCode();

        PaymentDTO payment = new PaymentDTO();
        payment.setPayCode(orderPayment.getPayCode());
        payment.setOrderCode(orderCode);
        payment.setPayPrice(orderPayment.getTotalPrice());
        payment.setPayType(orderPayment.getPayType());
        payment.setPayStatus(orderPayment.getPayStatus());
        payment.setPayDatetime(orderPayment.getPayDatetime());

        orderService.insertPayment(payment);

        return ResponseEntity.ok("/order/success");
    }

    @GetMapping("/success")
    public String orderSuccess (@RequestParam String payCode, Model model) {
        OrderResultDTO orderResult = orderService.selectOrderResult(payCode);

        model.addAttribute("orderResult", orderResult);

        return "order/success";
    }
}
