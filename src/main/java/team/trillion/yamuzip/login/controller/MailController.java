package team.trillion.yamuzip.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.trillion.yamuzip.login.model.service.MailServiceInter;
import team.trillion.yamuzip.login.model.service.RegisterMail;

@Controller
public class MailController {

    private final MailServiceInter mailServiceInter;

    public MailController(MailServiceInter mailServiceInter) {
        this.mailServiceInter = mailServiceInter;
    }

    @PostMapping("login/mailConfirm")
    @ResponseBody
    String mailConfirm(@RequestParam("email") String email) throws Exception {
        String code = mailServiceInter.sendSimpleMessage(email);
        System.out.println("인증코드 :" + code);
        return code;
    }

}
