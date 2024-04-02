package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.trillion.yamuzip.admin.model.dto.CalcDTO;
import team.trillion.yamuzip.admin.model.dto.CalcDetailDTO;
import team.trillion.yamuzip.admin.model.dto.CalcMonthlyDTO;
import team.trillion.yamuzip.admin.model.service.CalcService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public String getMonthlyCalc(@RequestParam(required = false) String selectMonth,
                                 Model model) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String formattedCurrentDate = currentDate.format(formatter);

        if(selectMonth == null) selectMonth = formattedCurrentDate;

        System.out.println(selectMonth);
        List<CalcDTO> calcList = calcService.findAllCalc(selectMonth);
        CalcMonthlyDTO calcMonthly = calcService.selectMonthlyDetail(selectMonth);

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
