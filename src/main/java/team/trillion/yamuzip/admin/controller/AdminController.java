package team.trillion.yamuzip.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dashboard")
public class AdminController {

    // 관리자 페이지
    @GetMapping("")
    public String getAdminPage() {
        return "admin/dashboard/dashboard";
    }

    // 관리자 페이지 > 회원관리 페이지
    @GetMapping("/user")
    public void getUserPage() {}

    // 관리자 페이지 > 정산관리 페이지
    @GetMapping("/acc")
    public void getServicePage() {}

}
