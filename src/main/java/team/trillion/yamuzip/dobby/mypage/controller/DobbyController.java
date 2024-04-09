package team.trillion.yamuzip.dobby.mypage.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.dobby.mypage.model.dto.*;
import team.trillion.yamuzip.dobby.mypage.model.service.ModifyService;
import team.trillion.yamuzip.dobby.mypage.model.service.ServiceService;
import team.trillion.yamuzip.login.model.dto.UserDTO;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/dobby")
@RequiredArgsConstructor
public class DobbyController {

    private final ModifyService modifyService;
    private final ServiceService serviceService;


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
    public String dobbyProfilePage(@AuthenticationPrincipal UserDTO user,
                                   Model model){

        /* 도비 정보 조회 */
        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());
        model.addAttribute("dobby", dobby);

        /* 영업일 */
        model.addAttribute("workdayList", dobby.getWorkdayList().stream().map(WorkdayDTO::getDayWeek).toList());

        /* 서비스 조회 */
        List<ServiceDTO> serviceList = serviceService.getService(dobby.getDobCode());

        model.addAttribute("serviceList",serviceList);


        return "dobby/profilePage";
    }


    // 도비 마이페이지 > 내 프로필 보러가기 > 내 정보 등록/수정 (ModifyController로 이동)


    // 도비 마이페이지 > 판매 관리 (OrderController로 이동)


    // 도비 마이페이지 > 내 서비스 (ServiceController로 이동)


    // 도비 마이페이지 > 수익 관리 (CalculateController로 이동)


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
