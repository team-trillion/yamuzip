package team.trillion.yamuzip.dobby.mypage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyTmpDTO;
import team.trillion.yamuzip.dobby.mypage.model.service.ModifyService;
import team.trillion.yamuzip.dobby.mypage.model.service.OrderService;
import team.trillion.yamuzip.dobby.mypage.model.dto.OrderCountDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.login.model.dto.UserDTO;
import team.trillion.yamuzip.order.model.dto.OrderRejectDTO;
import team.trillion.yamuzip.order.model.dto.PaymentDTO;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDetailDTO;
import team.trillion.yamuzip.order.model.service.PaymentService;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dobby")
public class OrderController {

    private final ModifyService modifyService;
    private final OrderService orderService;
    private final PaymentService paymentService;
    private final MessageSourceAccessor messageSourceAccessor;

    @GetMapping("/order")
    public String getOrderList(@AuthenticationPrincipal UserDTO user,
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(required = false) String start,
                               @RequestParam(required = false) String end,
                               @RequestParam(required = false) String searchCondition,
                               @RequestParam(required = false) String searchValue,
                               Model model) {

        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());
        if(dobby == null) {
            model.addAttribute("dobby", new ModifyDTO());
        }
        else {
            model.addAttribute("dobby", dobby);
        }

        Map<String, String> searchMap = new HashMap<>();
        if(searchCondition == null && !Objects.equals(searchValue, "") && searchValue != null)
            searchCondition = "serviceTitle";
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("start", start);
        searchMap.put("end", end);

        int dobCode = orderService.getDobCode(user.getUserCode());
        OrderCountDTO orderCount = orderService.getOrderCount(dobCode);

        Map<String, Object> orderListAndPaging = orderService.selectAllOrderList(dobCode, searchMap, page);
        model.addAttribute("paging", orderListAndPaging.get("paging"));

        List<OrderDTO> orderList = (List<OrderDTO>) orderListAndPaging.get("orderList");
        for(OrderDTO order : orderList) {
            order.setOrderDateString(order.getOrderDatetime().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
        model.addAttribute("user", user);
        model.addAttribute("orderCount", orderCount);
        model.addAttribute("orderList", orderList);

        return "dobby/order";
    }

    @GetMapping("/orderDetail")
    public String getUserOrderDetail(@AuthenticationPrincipal UserDTO user,
                                     @RequestParam int orderCode, Model model) {
        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());
        if(dobby == null)
            model.addAttribute("dobby", new ModifyDTO());
        else
            model.addAttribute("dobby", dobby);

        OrderDetailDTO orderDetail = orderService.selectOrderDetail(orderCode);

        orderDetail.setOrderDateString(orderDetail.getOrderDatetime()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        orderDetail.setReserveDateString(orderDetail.getReserveDatetime()
                .format(DateTimeFormatter.ISO_LOCAL_DATE));

        model.addAttribute("orderDetail", orderDetail);
        return "dobby/orderDetail";
    }

    @PostMapping("/orderApprove")
    public String approveOrder(@RequestParam int orderCode, RedirectAttributes rttr) {
        orderService.approveOrder(orderCode);
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("order.approve"));
        return "redirect:/dobby/order";
    }

    @PostMapping("/orderReject")
    public String rejectOrder(@RequestParam int orderCode,
                              @RequestParam String rejectReason,
                              @RequestParam(required = false) String rejectReasonEtc) throws IOException {

        String token = paymentService.getToken();
        PaymentDTO payment = paymentService.getPaymentByOrderCode(orderCode);
        String reason = rejectReasonEtc != null ? rejectReasonEtc : rejectReason;

        OrderRejectDTO orderReject = new OrderRejectDTO();
        orderReject.setPayCode(payment.getPayCode());
        orderReject.setOrderCode(orderCode);
        orderReject.setRejectReason(reason);

        orderService.rejectOrder(token, orderReject);

        return "redirect:/dobby/order";
    }

}
