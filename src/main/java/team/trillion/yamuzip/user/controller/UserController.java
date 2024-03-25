package team.trillion.yamuzip.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import team.trillion.yamuzip.user.dao.UserMapper;
import team.trillion.yamuzip.user.dto.UserDTO;
import team.trillion.yamuzip.user.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MessageSourceAccessor messageSourceAccessor;
    @Autowired
    private UserMapper userMapper;



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

@GetMapping("/getId")
public @ResponseBody List<String> fetchJsonTest() {

    return userService.getIds();
}



}
