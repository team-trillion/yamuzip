package team.trillion.yamuzip.user.mypage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.login.model.dto.UserDTO;
import team.trillion.yamuzip.user.mypage.model.service.MypageService;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

//    private final MypageService mypageService;

    // 유저 마이페이지 메인
    @GetMapping("")
    public String userMypage(Model model,
                             @AuthenticationPrincipal UserDTO user) {
//        OrderDTO order = mypageService.getOrder(user.getUserCode());
//        model.addAttribute("order", order);

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
        return "user/mypage/orderList";
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
