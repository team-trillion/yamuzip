package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.admin.model.dto.DobbyApplyDTO;
import team.trillion.yamuzip.admin.model.service.DobbyApplyService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin/apply")
public class DobbyApplyController {

    private final DobbyApplyService dobbyApplyService;

    public DobbyApplyController(DobbyApplyService dobbyApplyService) {
        this.dobbyApplyService = dobbyApplyService;
    }

    @GetMapping("/list")
    public String getApplyList(Model model) {

        List<DobbyApplyDTO> applyList = dobbyApplyService.findAllApply();

        model.addAttribute("applyList", applyList);

        return "admin/apply/list";
    }

    @GetMapping("/detail")
    public void getApplyDetail() {}

    @GetMapping("/accept")
    public void acceptApply() {}

    @GetMapping("/reject")
    public void rejectApply() {}
}
