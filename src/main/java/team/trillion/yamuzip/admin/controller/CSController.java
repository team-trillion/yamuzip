package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.admin.model.service.CSService;
import team.trillion.yamuzip.admin.model.dto.CSDTO;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin/cs")
public class CSController {

    private final CSService csService;

    public CSController(CSService csService) {
        this.csService = csService;
    }

    @GetMapping("/list")
    public String getCSList(@RequestParam(defaultValue = "1") int page,
                            Model model) {

        Map<String, Object> csListAndPaging = csService.getCSList(page);
        model.addAttribute("paging", csListAndPaging.get("paging"));

        List<CSDTO> csList = (List<CSDTO>) csListAndPaging.get("csList");
        for(CSDTO cs : csList) {
            cs.setCsCreatedString(cs.getCsCreated().format(DateTimeFormatter.ISO_LOCAL_DATE));
            cs.setIsSecret(cs.getCsSecret().equals("Y"));
        }

        model.addAttribute("csList", csList);
        return "admin/cs/list";
    }

}
