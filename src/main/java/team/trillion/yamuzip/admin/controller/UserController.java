package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.admin.model.dto.UserDTO;
import team.trillion.yamuzip.admin.model.service.UserService;

import java.util.List;

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

    @GetMapping("/detail")
    public void getUserDetail() {}

    @GetMapping("/ban")
    public void banUser() {}
}
