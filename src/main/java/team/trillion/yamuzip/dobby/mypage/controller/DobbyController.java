package team.trillion.yamuzip.dobby.mypage.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;
import team.trillion.yamuzip.dobby.mypage.model.service.ModifyService;
import team.trillion.yamuzip.login.model.dto.UserDTO;

@Slf4j
@Controller
@RequestMapping("/dobby")
@RequiredArgsConstructor
public class DobbyController {

    private final ModifyService modifyService;


    // 도비 마이페이지 메인
    @GetMapping("/mypage")
    public String dobbyMypage(Model model,
                              @AuthenticationPrincipal UserDTO user) {
        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());
        if(dobby == null) {
            model.addAttribute("dobby", new ModifyDTO());
        }
        else {
            model.addAttribute("dobby", dobby);

            System.out.println(dobby);

        }
        return "dobby/main";
    }

    // 도비 프로필
    @GetMapping("/profilePage")
    public String dobbyProfilePage(Model model,
                                   @AuthenticationPrincipal UserDTO user){

        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());
        if(dobby == null) {
            model.addAttribute("dobby", new ModifyDTO());
        }
        else {
            model.addAttribute("dobby", dobby);

            System.out.println(dobby);

        }
        return "dobby/profilePage";
    }

//    @GetMapping("/profile")
    public String dobbyProfile() {
        return "dobby/profile";
    }

    // 도비 마이페이지 > 판매 관리
    @GetMapping("/order")
    public String dobbyOrder(Model model,
                             @AuthenticationPrincipal UserDTO user) {
        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());
        if(dobby == null) {
            model.addAttribute("dobby", new ModifyDTO());
        }
        else {
            model.addAttribute("dobby", dobby);

            System.out.println(dobby);

        }
        return "dobby/order";
    }

    // 도비 마이페이지 > 내 서비스
    @GetMapping("/service")
    public String dobbyService(Model model,
                               @AuthenticationPrincipal UserDTO user) {
        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());
        if(dobby == null) {
            model.addAttribute("dobby", new ModifyDTO());
        }
        else {
            model.addAttribute("dobby", dobby);

            System.out.println(dobby);

        }
        return "dobby/service";
    }

    // 도비 마이페이지 > 수익 관리
    @GetMapping("/calc")
    public String dobbyCalc(Model model,
                            @AuthenticationPrincipal UserDTO user) {
        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());
        if(dobby == null) {
            model.addAttribute("dobby", new ModifyDTO());
        }
        else {
            model.addAttribute("dobby", dobby);

            System.out.println(dobby);

        }
        return "dobby/calc";
    }

    // 도비 마이페이지 > 문의 관리
    @GetMapping("/cs")
    public String dobbyCs(Model model,
                          @AuthenticationPrincipal UserDTO user) {
        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());
        if(dobby == null) {
            model.addAttribute("dobby", new ModifyDTO());
        }
        else {
            model.addAttribute("dobby", dobby);

            System.out.println(dobby);

        }
        return "dobby/cs";
    }
}
