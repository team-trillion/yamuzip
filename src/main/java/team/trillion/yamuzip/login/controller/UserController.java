package team.trillion.yamuzip.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import team.trillion.yamuzip.login.dao.UserMapper;
import team.trillion.yamuzip.login.dto.UserDTO;
import team.trillion.yamuzip.login.service.UserService;

import java.util.*;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MessageSourceAccessor messageSourceAccessor;




    @GetMapping("/login")
    public String getLoginPage(){
        return "login/login";
    }

    @PostMapping("/login")
    public String getLoginPage1(@RequestParam String userId , @RequestParam String userPwd){



        return "redirect:/main";
    }



    @GetMapping("/regist")
    public String getregistPage() {
        return "login/regist";
    }

    @PostMapping("/regist")
    public String regist(@ModelAttribute UserDTO user, RedirectAttributes rttr) {
        System.out.println(user);
        userService.regist(user);
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("user.regist"));
        return "redirect:/login";
    }

    @GetMapping("/getId")
    public @ResponseBody List<String> fetchJsonTest() {

        return userService.getIds();
    }







    @GetMapping("/findId")
    public String findId() {return "/login/findId";}


    @PostMapping("/findId")
    public ResponseEntity<?> findUserId(@RequestBody Map<String, String> requestData) {
        String name = requestData.get("name");
        String email = requestData.get("email");
        List<String> userIdList = userService.findUserId(name, email);
        if (userIdList.isEmpty()) {
            return ResponseEntity.notFound().build(); // 아이디를 찾을 수 없는 경우 404 응답을 반환합니다.
        } else {
            // 아이디를 찾은 경우 첫 번째 아이디를 반환합니다.
            String userId = userIdList.get(0);
            return ResponseEntity.ok(Collections.singletonMap("userId", userId));
        }
    }




    @GetMapping("/findPwd")
    public String findPwd() {return "login/findPwd";}










}
