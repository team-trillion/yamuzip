package team.trillion.yamuzip.user.mypage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.login.model.dto.UserDTO;
import team.trillion.yamuzip.user.mypage.model.dto.WishDTO;
import team.trillion.yamuzip.user.mypage.model.service.WistService;

import java.util.List;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class WishController {

    private final WistService wistService;

    @GetMapping("/service")
    public String userService(Model model,
                              @AuthenticationPrincipal UserDTO user) {

        List<WishDTO> wishList = wistService.getWish(user.getUserCode());
        model.addAttribute("wishList",wishList);
        System.out.println(wishList);

        return "user/mypage/service";
    }
}
