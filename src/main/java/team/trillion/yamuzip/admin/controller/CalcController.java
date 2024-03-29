package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.admin.model.dto.CalcDTO;
import team.trillion.yamuzip.admin.model.service.CalcService;

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
    public String getMonthlyCalc(Model model) {

        List<CalcDTO> calcList = calcService.findAllCalc();

        model.addAttribute("calcList", calcList);

        return "admin/calc/monthly";
    }

    @GetMapping("/detail")
    public void getCalcDetail() {}

    @GetMapping("/complete")
    public void completeCalc() {}

    @GetMapping("/detailpay")
    public void getDetailPayment() {}

}
