package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin/order")
public class OrderController {

    @GetMapping("/list")
    public void getOrderList() {}

    @GetMapping("/detail")
    public void getOrderDetail() {}

    @GetMapping("/cancel")
    public void cancelOrder() {}


}
