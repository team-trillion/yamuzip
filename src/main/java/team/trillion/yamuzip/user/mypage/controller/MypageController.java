package team.trillion.yamuzip.user.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    // 유저 마이페이지 메인
    @GetMapping("")
    public String userMypage() {
        return "user/mypage/main";
    }

    // 유저 정보
//    @GetMapping("/profile")
    public String modifyUser() {
        return "user/mypage/profile";
    }

    // 유저 마이페이지 > 관심 서비스
    @GetMapping("/service")
    public String userService() {
        return "user/mypage/service";
    }

    // 유저 마이페이지 > 주문 관리
    // @GetMapping("/order")
    public String userOrder() {
        return "user/mypage/order";
    }

    // 유저 마이페이지 > 리뷰 쓰기
    @GetMapping("/review")
    public String userReview() {
        return "user/mypage/review";
    }

    // 유저 마이페이지 > 문의하기
    @GetMapping("/cs")
    public String userCs() {
        return "user/mypage/cs";
    }
}
