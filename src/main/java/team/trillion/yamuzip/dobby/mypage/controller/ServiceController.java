package team.trillion.yamuzip.dobby.mypage.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ServiceDTO;
import team.trillion.yamuzip.dobby.mypage.model.service.ModifyService;
import team.trillion.yamuzip.dobby.mypage.model.service.ServiceService;
import team.trillion.yamuzip.login.model.dto.UserDTO;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/dobby")
@RequiredArgsConstructor
public class ServiceController {

    private final ModifyService modifyService;
    private final ServiceService serviceService;

    // 도비 마이페이지 > 내 서비스
    @GetMapping("/service")
    public String dobbyService(Model model,
                               @AuthenticationPrincipal UserDTO user) {

        /* 도비 정보 조회 */

        ModifyDTO dobby = modifyService.getDobby(user.getUserCode());
        model.addAttribute("dobby", dobby);

        /* 서비스 조회 */

        List<ServiceDTO> serviceList = serviceService.getService(dobby.getDobCode());

        model.addAttribute("serviceList",serviceList);

        return "dobby/service";
    }
}
