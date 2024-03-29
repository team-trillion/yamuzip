package team.trillion.yamuzip.dobby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dobby")
public class DobbyController {

    // 도비 마이페이지 메인
    @GetMapping("/mypage")
    public String dobbyMypage() {
        return "dobby/main";
    }

    // 도비 프로필
    @GetMapping("/profile")
    public String dobbyProfile() {
        return "dobby/profile";
    }

    // 도비 마이페이지 > 판매 관리
    @GetMapping("/order")
    public String dobbyOrder() {
        return "dobby/order";
    }

    // 도비 마이페이지 > 내 서비스
    @GetMapping("/service")
    public String dobbyService() {
        return "dobby/service";
    }

    // 도비 마이페이지 > 수익 관리
    @GetMapping("/calc")
    public String dobbyCalc() {
        return "dobby/calc";
    }

    // 도비 마이페이지 > 문의 관리
    @GetMapping("/cs")
    public String dobbyCs() {
        return "dobby/cs";
    }
}
