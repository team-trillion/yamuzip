package team.trillion.yamuzip.dobby.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.dobby.model.dto.DobbyRegistDTO;
import team.trillion.yamuzip.dobby.model.service.DobbyRegistService;
import team.trillion.yamuzip.login.model.dto.UserDTO;

@Slf4j
@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class DobbyRegistController {

    private final DobbyRegistService registDobbyService;

    // 도비 등록 유도 페이지
    @GetMapping("/become-a-dobby")
    public String registPage() {
        return "dobby/registPage";
    }

    // 도비 등록 페이지
    @GetMapping("/dobby")
    public String registDobby() {
        return "dobby/regist";
    }

    @PostMapping("/dobby")
    public String registDobby(@RequestParam("applyCareer") String applyCareer, @AuthenticationPrincipal UserDTO user) {

        DobbyRegistDTO registDobby = new DobbyRegistDTO();
        registDobby.setApplyCareer(applyCareer);
        registDobby.setUserCode(user.getUserCode());

        int dobbyApplyResult = registDobbyService.selectDobbyApplyByUserCode(user.getUserCode());
        if (dobbyApplyResult > 0) {
            throw new RuntimeException("cannot apply ~~");
        }

        registDobbyService.registDobby(registDobby);
        return "redirect:/";
    }


}
