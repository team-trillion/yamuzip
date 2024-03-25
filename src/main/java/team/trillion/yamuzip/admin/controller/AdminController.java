package team.trillion.yamuzip.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dashboard")
public class AdminController {

    // 관리자 페이지 이동
    @GetMapping("/dashboard")
    public void getAdminPage() {}

    @GetMapping("/user")
    public void getUserPage() {}
}
