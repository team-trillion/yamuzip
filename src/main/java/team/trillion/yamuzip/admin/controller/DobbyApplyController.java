package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin/apply")
public class DobbyApplyController {

    @GetMapping("/list")
    public void getApplyList() {}

    @GetMapping("/detail")
    public void getApplyDetail() {}

    @GetMapping("/accept")
    public void acceptApply() {}

    @GetMapping("/reject")
    public void rejectApply() {}
}
