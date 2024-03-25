package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin/cs")
public class CsController {

    @GetMapping("/list")
    public void getCSList() {}

    @GetMapping("/detail")
    public void getCSDetail() {}

}
