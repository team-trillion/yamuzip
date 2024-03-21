package team.trillion.yamuzip.main.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MainController {

    @GetMapping("/")
    public String defaultRequest() {
        return "main";
    }

    @GetMapping("/ex")
    public String ex() {
        return "ex/ex";
    }

    @GetMapping("/regist")
    public String sadf() {return "user/regist";}

    @GetMapping("/login")
    public String dssd() {return "user/login";}

    @GetMapping("/findId")
    public String findId() {return "user/findId";}

    @GetMapping("/findPwd")
    public String findPwd() {return "user/findPwd";}

}

