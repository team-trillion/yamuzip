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
    public String getLoginPage(){
        return "user/login";
    }

    @PostMapping("/login")
    public String getLoginPage1(@RequestParam String userId , @RequestParam String userPwd){



        return "redirect:/main";
    }

    @GetMapping("/regist")
    public String getregistPage() {
        return "user/regist";
    }

    @PostMapping("/regist")
    public String regist(@ModelAttribute UserDTO user, RedirectAttributes rttr) {
        System.out.println(user);
        userService.regist(user);
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("user.regist"));
        return "redirect:/user/login";
    }
//    @GetMapping("/findId")
//    public String findId() {
//        return "user/login";
//    }
//
//    @GetMapping("/findPwd")
//    public String findPwd() {
//        return "user/login";
//    }
@GetMapping("/findId")
public String findId() {return "/user/findId";}

    @GetMapping("/findPwd")
    public String findPwd() {return "user/findPwd";}





}
