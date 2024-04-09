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
import team.trillion.yamuzip.dobby.mypage.model.dto.CalculateDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ServiceStatusDTO;
import team.trillion.yamuzip.dobby.mypage.model.service.AccountService;
import team.trillion.yamuzip.dobby.mypage.model.service.CalculateService;
import team.trillion.yamuzip.dobby.mypage.model.service.ModifyService;
import team.trillion.yamuzip.login.model.dto.UserDTO;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/dobby")
@RequiredArgsConstructor
public class CalculateController {

    private final ModifyService modifyService;
    private final AccountService accountService;
    private final CalculateService calculateService;

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

        /* 출금 가능 수익금 조회 */
        CalculateDTO totalAvailablePrice = calculateService.getAvailableForWithdrawal(dobby.getDobCode());
        System.out.println(totalAvailablePrice);
        model.addAttribute("totalAvailablePrice", totalAvailablePrice);

        /* 출금 완료 수익금 조회 */
        CalculateDTO totalCompletedPrice = calculateService.getWithdrawalsCompleted(dobby.getDobCode());
        System.out.println(totalCompletedPrice);
        model.addAttribute("totalCompletedPrice", totalCompletedPrice);

        /* 서비스 정산 여부 조회 */
        List<ServiceStatusDTO> settlementStatusList = calculateService.SettlementStatus(dobby.getDobCode());
        System.out.println("미정산된 서비스" + settlementStatusList);
        model.addAttribute("settlementStatusList", settlementStatusList);

        return "dobby/calc";
    }


    // 도비 마이페이지 > 수익 관리 > 계좌 등록
    @PostMapping("/calc")
    public String modifyDobby(Model model,
                              @RequestParam String accBank,
                              @RequestParam String accNumber,
                              @RequestParam String accName,
                              @AuthenticationPrincipal UserDTO user) {

        /* 도비 계좌 등록 */
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
