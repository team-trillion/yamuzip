package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import team.trillion.yamuzip.admin.model.dto.DobbyApplyDTO;
import team.trillion.yamuzip.admin.model.service.DobbyApplyService;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

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

    @PostMapping("/control")
    public String applyDobbyControl(@RequestParam Integer applyCode,
                                    @RequestParam String userCode,
                                    @RequestParam String result,
                                    @RequestParam (required = false) LocalDateTime applyDone,
                                    @RequestParam String applyRejectReason) {

        if (applyDone == null) {
            applyDone = LocalDateTime.now();
        }

        Map<String, Object> applyMap = new HashMap<>();
        applyMap.put("applyCode", applyCode);
        applyMap.put("userCode", userCode);
        applyMap.put("result", result);
        applyMap.put("applyDone", applyDone);
        applyMap.put("applyRejectReason", applyRejectReason);
        dobbyApplyService.applyControl(applyMap);

        return "redirect:/admin/apply/list";

    }


//    @GetMapping("/detail")
//    public @ResponseBody DobbyApplyDTO getApplyDetail(@RequestParam Long applyCode) {
//
//    return null;
//    }

    @GetMapping("/accept")
    public void acceptApply() {}

    @GetMapping("/reject")
    public void rejectApply() {}
}
