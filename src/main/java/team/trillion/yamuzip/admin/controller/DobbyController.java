package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.admin.model.dto.DobbyDTO;
import team.trillion.yamuzip.admin.model.service.DobbyService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin/dobby")
public class DobbyController {

    private final DobbyService dobbyService;

    public DobbyController(DobbyService dobbyService) {
        this.dobbyService = dobbyService;
    }

    @GetMapping("/list")
    public String getDobbyList(Model model) {

        List<DobbyDTO> dobbyList = dobbyService.findAllDobby();

        model.addAttribute("dobbyList", dobbyList);

        return "admin/dobby/list";
    }

    @GetMapping("/detail")
    public void getDobbyDetail() {}

    @GetMapping("/ban")
    public void banDobby() {}
}
