package team.trillion.yamuzip.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.trillion.yamuzip.login.model.dao.FindMailServiceinter;

@Controller
public class FindPwdController {

    private final FindMailServiceinter findMailServiceinter;

    public FindPwdController(FindMailServiceinter findMailServiceinter) {
        this.findMailServiceinter = findMailServiceinter;
    }


    @PostMapping("findPwd/mailConfirm")
    @ResponseBody
    String findPwd(@RequestParam("email") String email) throws Exception {

        // 서비스 불러서 아이디랑 이메일 일치하는지 체크 붕일치 에러

        String code = findMailServiceinter.sendSimpleMessage(email);


        System.out.println("인증코드 :" + code);
        return code;
    }

    @PostMapping("findPwd/sendPasswordResetCode")
    public String sendPasswordResetCode(@RequestParam String email, Model model) {


        try {
            String tempPassword = findMailServiceinter.sendPasswordResetCode(email);
            model.addAttribute("message", "임시 비밀번호를 성공적으로 발송 함.");
            return "redirect:/login/login";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "임시 비밀번호 발송중 오류 발생");
            return "redirect:/login/findPwd";
        }
    }


}
