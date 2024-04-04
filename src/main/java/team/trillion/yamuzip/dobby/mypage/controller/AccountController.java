package team.trillion.yamuzip.dobby.mypage.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.auth.service.AuthService;
import team.trillion.yamuzip.dobby.mypage.model.dto.AccountDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;
import team.trillion.yamuzip.dobby.mypage.model.service.AccountService;
import team.trillion.yamuzip.dobby.mypage.model.service.ModifyService;
import team.trillion.yamuzip.login.model.dto.UserDTO;

import java.util.function.Predicate;

@Slf4j
@Controller
@RequestMapping("/dobby")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final ModifyService modifyService;
    private final AuthService authenticationService;


    // 도비 마이페이지 > 수익 관리
    @GetMapping("/calc")
    public String dobbyCalc(Model model,
                            @AuthenticationPrincipal UserDTO user) {

        /* 도비 정보 조회 */
        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());
        model.addAttribute("dobby", dobby);

        /* 계좌 정보 조회 */
        AccountDTO accountDobby = accountService.getAccount(dobby.getDobCode());
        System.out.println(accountDobby);
        model.addAttribute("accountDobby", accountDobby);

//        if(dobby == null) {
//            model.addAttribute("dobby", new ModifyDTO());
//        }
//        else {
//            model.addAttribute("dobby", dobby);
//
//            System.out.println(dobby);
//
//        }

        return "dobby/calc";
    }


    // 도비 마이페이지 > 수익 관리 > 계좌 등록
    @PostMapping("/calc")
    public String modifyDobby(Model model,
                              @RequestParam String accBank,
                              @RequestParam String accNumber,
                              @RequestParam String accName,
                              @AuthenticationPrincipal UserDTO user) {

        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());
        AccountDTO modifyDobby = new AccountDTO();
        modifyDobby.setDobCode(dobby.getDobCode());
        modifyDobby.setAccBank(accBank);
        modifyDobby.setAccNumber(accNumber);
        modifyDobby.setAccName(accName);

        accountService.modifyAccount(modifyDobby);

        /* 도비 정보 조회 */
        model.addAttribute("dobby", dobby);

        log.info(String.valueOf(dobby));

        return "redirect:/dobby/calc";
    }


}
