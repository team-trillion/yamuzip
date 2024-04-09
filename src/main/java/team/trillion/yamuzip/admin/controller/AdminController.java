package team.trillion.yamuzip.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.trillion.yamuzip.admin.model.dto.ChartDTO;
import team.trillion.yamuzip.admin.model.dto.DobbyServiceDTO;
import team.trillion.yamuzip.admin.model.service.AdminService;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/admin/dashboard")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // 관리자 페이지
    @GetMapping("")
    public String getAdminPage(Model model) {

        List<ChartDTO> registList = adminService.selectWeeklyRegist();
        for(ChartDTO regist : registList) {
            regist.setRegistDateString(regist.getRegistDate().format(DateTimeFormatter.ofPattern("yy.MM.dd")));
        }

        List<ChartDTO> orderList = adminService.selectMonthlyOrderByCategory();
        List<ChartDTO> statusList = adminService.selectMonthlyOrderByStatus();

        model.addAttribute("registList", registList);
        model.addAttribute("orderList", orderList);
        model.addAttribute("statusList", statusList);

        return "admin/dashboard/dashboard";
    }

    // 관리자 페이지 > 회원관리 페이지
    @GetMapping("/user")
    public void getUserPage() {}

    // 관리자 페이지 > 정산관리 페이지
    @GetMapping("/acc")
    public void getServicePage() {}

}
