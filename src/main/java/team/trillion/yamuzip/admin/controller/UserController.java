package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.admin.model.dto.UserDTO;
import team.trillion.yamuzip.admin.model.service.UserService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String getUserList(Model model) {

        List<UserDTO> userList = userService.findAllUser();

        model.addAttribute("userList", userList);

        return "admin/user/list";
    }

    @GetMapping("/banList")
    public String getBanList(Model model) {

        List<UserDTO> banUserList = userService.findAllBanUser();

        model.addAttribute("banUserList", banUserList);

        return "admin/user/banList";
    }

    @PostMapping("/ban")
    public String banControl(@RequestParam Integer userCode,
                             @RequestParam String userStatus,
                             @RequestParam (required = false) LocalDateTime unban) {

        if (unban == null) {
            unban = LocalDateTime.now().plusYears(1);
        }

        Map<String, Object> banMap = new HashMap<>();
        banMap.put("userCode", userCode);
        banMap.put("userStatus", userStatus);
        banMap.put("unban", unban);
        userService.banControl(banMap);

        return "redirect:/admin/user/ban?userCode=" + userCode + "&userStatus=" + userStatus + "&unban=" + unban;
    }

    @GetMapping("/ban")
    public String banUser(@RequestParam Integer userCode,
                          @RequestParam String userStatus,
                          @RequestParam (required = false) LocalDateTime unban,
                          Model model) {

        Map<String, Object> banMap = new HashMap<>();
        banMap.put("userCode", userCode);
        banMap.put("userStatus", userStatus);
        banMap.put("unban", unban);
        userService.banControl(banMap);

        UserDTO userInfo = userService.findBanUser(userCode);
        model.addAttribute("userInfo", userInfo);
        System.out.println(userInfo);

        return "admin/user/ban";

    }

    @PostMapping("/banModify")
    public String banModifyControl(@RequestParam Integer userCode,
                                   @RequestParam String userStatus,
                                   @RequestParam (required = false) LocalDateTime unban) {

        Map<String, Object> banMap = new HashMap<>();
        banMap.put("userCode", userCode);
        banMap.put("userStatus", userStatus);
        banMap.put("unban", unban);
        userService.banControl(banMap);

        return "redirect:/admin/user/banList";
    }

    @GetMapping("/detail")
    public void getUserDetail() {}

}
