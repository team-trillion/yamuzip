package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin/dobby")
public class DobbyController {

    @GetMapping("/list")
    public void getDobbyList() {}

    @GetMapping("/detail")
    public void getDobbyDetail() {}

    @GetMapping("/ban")
    public void banDobby() {}
}
