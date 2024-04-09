package team.trillion.yamuzip.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.admin.model.dto.CSReplyDTO;
import team.trillion.yamuzip.admin.model.service.CSReplyService;
import team.trillion.yamuzip.login.model.dto.UserDTO;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/csReply")
public class CSReplyController {

    private final CSReplyService csReplyService;

    @PostMapping("/regist")
    public String registReply(@ModelAttribute CSReplyDTO csReply, @AuthenticationPrincipal UserDTO user) {
        csReply.setWriterUserCode(user.getUserCode());

        System.out.println(csReply);
        csReplyService.registReply(csReply);
        return "redirect:/admin/cs/detail?csCode=" + csReply.getCsCode();
    }

    @PostMapping("/modify")
    public String modifyReply(@RequestBody CSReplyDTO csReply) {
        csReplyService.modifyReply(csReply);
        return "redirect:/admin/cs/detail?csCode=" + csReply.getCsCode();
    }

    @PostMapping("/delete")
    public String deleteReply(@RequestBody CSReplyDTO csReply) {
        csReplyService.deleteReply(csReply);

        return "redirect:/admin/cs/detail?csCode=" + csReply.getCsCode();
    }
}
