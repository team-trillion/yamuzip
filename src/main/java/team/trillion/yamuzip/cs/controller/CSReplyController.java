package team.trillion.yamuzip.cs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.trillion.yamuzip.cs.model.dto.CSReplyDTO;
import team.trillion.yamuzip.cs.model.service.CSReplyService;
import team.trillion.yamuzip.login.model.dto.UserDTO;

@Controller
@RequiredArgsConstructor
@RequestMapping("/csReply")
public class CSReplyController {

    private final CSReplyService csReplyService;

    @PostMapping("/regist")
    public String registReply(@ModelAttribute CSReplyDTO csReply, @AuthenticationPrincipal UserDTO user) {
        csReply.setWriterUserCode(user.getUserCode());
        csReplyService.registReply(csReply);
        return "redirect:/cs/detail?csCode=" + csReply.getCsCode();
    }

    @PostMapping("/modify")
    public String modifyReply(@RequestBody CSReplyDTO csReply) {
        csReplyService.modifyReply(csReply);
        return "redirect:/cs/detail?csCode=" + csReply.getCsCode();
    }

    @PostMapping("/delete")
    public String deleteReply(@RequestBody CSReplyDTO csReply) {
        csReplyService.deleteReply(csReply);

        return "redirect:/cs/detail?csCode=" + csReply.getCsCode();
    }
}
