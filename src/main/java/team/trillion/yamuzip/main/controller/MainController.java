package team.trillion.yamuzip.main.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MainController {

    @GetMapping(value = {"/main","/"})
    public String defaultRequest() {
        return "main";
    }

    @GetMapping("/admin")
    public String ex() {
        return "admin/dashboard/dashboard";
    }

//    @GetMapping("/regist")
//    public String sadf() {return "user/regist";}

//    @GetMapping("/login")
//    public String getLoginPage() {return "user/login";}


//    @GetMapping("/user/findId")
//    public String findId() {return "/user/findId";}

//    @GetMapping("/user/findPwd")
//    public String findPwd() {return "user/findPwd";}

}

