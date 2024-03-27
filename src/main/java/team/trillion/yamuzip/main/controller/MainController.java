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

    @GetMapping("/ex")
    public String ex() {
        return "ex/ex";
    }

}

