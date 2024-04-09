package team.trillion.yamuzip.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.admin.model.service.CSReplyService;
import team.trillion.yamuzip.admin.model.service.CSService;
import team.trillion.yamuzip.admin.model.dto.CSDTO;
import team.trillion.yamuzip.admin.model.dto.CSReplyDTO;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin/cs")
public class CSController {

    private final CSService csService;
    private final CSReplyService csReplyService;

    public CSController(CSService csService, CSReplyService csReplyService) {
        this.csService = csService;
        this.csReplyService = csReplyService;
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

    @GetMapping("/detail")
    public String getCSDetail(@RequestParam int csCode, Model model) {
        CSDTO cs = csService.getCSDetail(csCode);
        cs.setCsCreatedString(cs.getCsCreated().format(DateTimeFormatter.ISO_LOCAL_DATE));
        cs.setIsSecret(cs.getCsSecret().equals("Y"));
        model.addAttribute("cs", cs);

        CSReplyDTO csReply = csReplyService.getCSReply(csCode);
        if(csReply != null)
            csReply.setCsRepCreatedString(csReply.getCsRepCreated().format(DateTimeFormatter.ISO_LOCAL_DATE));
        model.addAttribute("csReply", csReply);

        return "admin/cs/detail";
    }

}
