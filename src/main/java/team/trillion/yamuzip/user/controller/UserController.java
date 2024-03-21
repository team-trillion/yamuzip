package team.trillion.yamuzip.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import team.trillion.yamuzip.user.dto.UserDTO;
import team.trillion.yamuzip.user.service.UserService;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MessageSourceAccessor messageSourceAccessor;

    @GetMapping("/login")
    public void getLoginPage(){}

    @GetMapping("/regist")
    public void getregistPage(){}

    @PostMapping ("/regist")
    public String userregist(@ModelAttribute UserDTO user, RedirectAttributes rttr) {

        userService.registUser(user);
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("user.regist"));


        return "/user/regist";
    }
    @GetMapping("/login")
    public String userlogin() {
        return "/user/login";  // 로그인창 이동
    }
}
