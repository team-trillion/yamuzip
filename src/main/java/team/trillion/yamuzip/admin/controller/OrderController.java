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

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public String getOrderList(Model model) {

        List<OrderDTO> orderList = orderService.findAllOrder();

        model.addAttribute("orderList", orderList);

        return "admin/order/list";

    }

    @GetMapping("/detail")
    public String getOrderDetail(@RequestParam int orderCode, Model model) {

        OrderDetailDTO orderDetail = orderService.selectOrderDetail(orderCode);

        model.addAttribute("orderDetail", orderDetail);

        return "admin/order/detail";
    }

    @GetMapping("/cancel")
    public void cancelOrder() {}


}
