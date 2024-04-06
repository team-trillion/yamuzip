package team.trillion.yamuzip.dobby.regist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.dobby.regist.model.dto.RegistDTO;
import team.trillion.yamuzip.dobby.regist.model.service.RegistService;
import team.trillion.yamuzip.login.model.dto.UserDTO;

@Slf4j
@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class RegistController {

    private final RegistService registService;

    // 도비 등록 유도 페이지
    @GetMapping("/become-a-dobby")
    public String registPage() {
        return "dobby/registPage";
    }

    // 도비 등록 페이지
    @GetMapping("/dobby")
    public String getDobby() { return "dobby/regist"; }


    // 등록 신청 내역
    @PostMapping("/dobby")
    public String registDobby(@RequestParam("applyCareer") String applyCareer, @AuthenticationPrincipal UserDTO user) {

        RegistDTO registDobby = new RegistDTO();
        registDobby.setApplyCareer(applyCareer);
        registDobby.setUserCode(user.getUserCode());

        // 도비 중복 신청 불가 (applyStatus가 c일때)
        int dobbyApplyResult = registService.selectApplyStatus(user.getUserCode());
        if (dobbyApplyResult == 1) {
            throw new RuntimeException("중복 신청은 불가합니다");
        }

        registService.registDobby(registDobby);

        return "redirect:/";
    }

}
