package team.trillion.yamuzip.user.mypage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDetailDTO;
import team.trillion.yamuzip.user.mypage.model.service.OrderService;
import team.trillion.yamuzip.login.model.dto.UserDTO;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order")
    public String userOrder(@AuthenticationPrincipal UserDTO user,
                            @RequestParam(defaultValue = "1") int page,
                            @RequestParam(required = false) String start,
                            @RequestParam(required = false) String end,
                            @RequestParam(required = false) String searchCondition,
                            @RequestParam(required = false) String searchValue,
                            Model model) {

        Map<String, String> searchMap = new HashMap<>();
        if(searchCondition == null && !Objects.equals(searchValue, "") && searchValue != null)
            searchCondition = "serviceTitle";
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("start", start);
        searchMap.put("end", end);

        Map<String, Object> orderListAndPaging = orderService.selectAllOrderList(user.getUserCode(), searchMap, page);
        model.addAttribute("paging", orderListAndPaging.get("paging"));

        List<OrderDTO> orderList = (List<OrderDTO>) orderListAndPaging.get("orderList");
        for(OrderDTO order : orderList) {
            order.setOrderDateString(order.getOrderDatetime().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
        model.addAttribute("user", user);
        model.addAttribute("orderList", orderList);

        return "user/mypage/orderList";
    }

    @GetMapping("/cancelList")
    public String getCancelList(@AuthenticationPrincipal UserDTO user,
                            @RequestParam(defaultValue = "1") int page,
                            @RequestParam(required = false) String start,
                            @RequestParam(required = false) String end,
                            @RequestParam(required = false) String searchCondition,
                            @RequestParam(required = false) String searchValue,
                            Model model) {

        Map<String, String> searchMap = new HashMap<>();
        if(searchCondition == null && !Objects.equals(searchValue, "") && searchValue != null)
            searchCondition = "serviceTitle";
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("start", start);
        searchMap.put("end", end);

        Map<String, Object> cancelListAndPaging = orderService.selectAllCancelList(user.getUserCode(), searchMap, page);
        model.addAttribute("paging", cancelListAndPaging.get("paging"));

        List<OrderDTO> cancelList = (List<OrderDTO>) cancelListAndPaging.get("cancelList");
        for(OrderDTO order : cancelList) {
            order.setOrderDateString(order.getOrderDatetime().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
        model.addAttribute("user", user);
        model.addAttribute("cancelList", cancelList);

        return "user/mypage/cancelList";
    }

    @GetMapping("/orderDetail")
    public String getUserOrderDetail(@RequestParam int orderCode, Model model) {
        OrderDetailDTO orderDetail = orderService.selectOrderDetail(orderCode);

        orderDetail.setOrderDateString(orderDetail.getOrderDatetime()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        orderDetail.setReserveDateString(orderDetail.getReserveDatetime()
                .format(DateTimeFormatter.ISO_LOCAL_DATE));

        model.addAttribute("orderDetail", orderDetail);
        return "user/mypage/orderDetail";
    }

    @GetMapping("/cancelDetail")
    public String getUserCancelDetail(@RequestParam int orderCode, Model model) {
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
        return "user/mypage/cancelDetail";
    }

}
