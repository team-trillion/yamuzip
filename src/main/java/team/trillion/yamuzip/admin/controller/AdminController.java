package team.trillion.yamuzip.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.admin.model.dto.ChartDTO;
import team.trillion.yamuzip.admin.model.service.AdminService;

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

        List<ChartDTO> chartList = adminService.selectWeeklyRegist();

        model.addAttribute("chartList", chartList);

        return "admin/dashboard/dashboard";
    }

}
