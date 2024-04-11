package team.trillion.yamuzip.user.mypage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.login.model.dto.UserDTO;
import team.trillion.yamuzip.user.mypage.model.dto.OrderStatusDTO;
import team.trillion.yamuzip.user.mypage.model.service.MypageService;
import team.trillion.yamuzip.user.mypage.model.service.OrderStatusService;

import java.util.List;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

        private final OrderStatusService orderStatusService;


    // 유저 마이페이지 메인
    @GetMapping("")
    public String userMypage(Model model,
                             @AuthenticationPrincipal UserDTO user) {

        List<OrderStatusDTO> orderStatusList =  orderStatusService.orderStatus(user.getUserCode());
        System.out.println(orderStatusList);
        model.addAttribute("orderStatusList",orderStatusList);

        System.out.println("user : " + user);
        return "user/mypage/main";
    }

    // 유저 정보
//    @GetMapping("/profile")
    public String modifyUser() {
        return "user/mypage/profile";
    }

    // 유저 마이페이지 > 관심 서비스 (WishController로 이동)

    // 유저 마이페이지 > 주문 관리 (OrderController로 이동)

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
