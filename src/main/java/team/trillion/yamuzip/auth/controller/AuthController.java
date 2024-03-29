package team.trillion.yamuzip.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final MessageSourceAccessor messageSourceAccessor;

    @PostMapping("error/login")
    public String loginFailed(RedirectAttributes rttr) {
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("error.login")); // 로그인실패시  메세지 전송

        return "redirect:/login";
    }

    @GetMapping("error/admin")
    public String accessDenied(RedirectAttributes rttr) {
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("error.denied"));

        return "redirect:/";

    }
}
