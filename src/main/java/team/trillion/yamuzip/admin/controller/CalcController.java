package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.admin.model.dto.CalcDTO;
import team.trillion.yamuzip.admin.model.dto.CalcDetailDTO;
import team.trillion.yamuzip.admin.model.dto.CalcMonthlyDTO;
import team.trillion.yamuzip.admin.model.service.CalcService;

import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin/calc")
public class CalcController {

    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/monthly")
    public String getMonthlyCalc(@RequestParam String selectMonth,
                                 Model model) {

        List<CalcDTO> calcList = calcService.findAllCalc();
        CalcMonthlyDTO calcMonthly = calcService.selectMonthlyDetail(selectMonth);
        System.out.println(selectMonth);

        model.addAttribute("calcList", calcList);
        model.addAttribute("calcMonthly", calcMonthly);

        return "admin/calc/monthly";
    }

    @GetMapping("/detail")
    public String getCalcDetail(@RequestParam int orderCode, Model model) {

        CalcDetailDTO calcDetail = calcService.selectCalcDetail(orderCode);

        model.addAttribute("calcDetail", calcDetail);

        return "admin/calc/detail";

    }

    @GetMapping("/complete")
    public void completeCalc() {}

    @GetMapping("/detailpay")
    public void getDetailPayment() {}

}
