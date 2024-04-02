package team.trillion.yamuzip.dobby.mypage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.dobby.mypage.model.OrderService;
import team.trillion.yamuzip.dobby.mypage.model.dto.OrderCountDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.login.model.dto.UserDTO;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDetailDTO;

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

    private final OrderService orderService;

    @GetMapping("/order")
    public String getOrderList(@AuthenticationPrincipal UserDTO user,
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
    public String getUserOrderDetail(@RequestParam int orderCode, Model model) {
        OrderDetailDTO orderDetail = orderService.selectOrderDetail(orderCode);

        orderDetail.setOrderDateString(orderDetail.getOrderDatetime()
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        orderDetail.setReserveDateString(orderDetail.getReserveDatetime()
                .format(DateTimeFormatter.ISO_LOCAL_DATE));

        model.addAttribute("orderDetail", orderDetail);
        return "dobby/orderDetail";
    }

}
