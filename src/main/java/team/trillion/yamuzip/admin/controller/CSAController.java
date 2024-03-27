package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin/csa")
public class CSAController {

    @GetMapping("/regist")
    public void registAnswer() {}

    @GetMapping("/modify")
    public void modifyAnswer() {}

    @GetMapping("/delete")
    public void deleteAnswer() {}

}
