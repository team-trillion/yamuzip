package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin/calc")
public class CalcController {

    @GetMapping("/monthly")
    public void getMonthlyCalc() {}

    @GetMapping("/detail")
    public void getCalcDetail() {}

    @GetMapping("/complete")
    public void completeCalc() {}

    @GetMapping("/detailpay")
    public void getDetailPayment() {}

}
