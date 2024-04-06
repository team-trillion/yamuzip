package team.trillion.yamuzip.cs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.trillion.yamuzip.common.exception.ReadAccessDeniedException;
import team.trillion.yamuzip.cs.model.dto.CSDTO;
import team.trillion.yamuzip.cs.model.service.CSService;
import team.trillion.yamuzip.login.model.dto.UserDTO;
import team.trillion.yamuzip.notice.model.dto.NoticeDTO;
import team.trillion.yamuzip.notice.model.service.NoticeService;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static team.trillion.yamuzip.login.model.Authority.ADMIN;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cs")
public class CSController {

    private final CSService csService;

    @GetMapping
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
        return "cs/cs";
    }

    @GetMapping("/detail")
    public String getCSDetail(@RequestParam int csCode, @AuthenticationPrincipal UserDTO user, Model model) {
        CSDTO cs = csService.getCSDetail(csCode);
        if(cs.getCsSecret().equals("Y") && (user == null || !(user.getAuth() == ADMIN) && user.getUserCode() != cs.getWriterUserCode())) {
            throw new ReadAccessDeniedException("비밀글 읽기 권한이 없습니다.");
        }
        cs.setCsCreatedString(cs.getCsCreated().format(DateTimeFormatter.ISO_LOCAL_DATE));
        cs.setIsSecret(cs.getCsSecret().equals("Y"));
        model.addAttribute("cs", cs);

        return "cs/detail";
    }

    @GetMapping("/regist")
    public String getCSRegistView() {
        return "cs/regist";
    }

    @PostMapping("/regist")
    public String registCS(@ModelAttribute CSDTO cs, @AuthenticationPrincipal UserDTO user) {
        if(cs.getIsSecret()) cs.setCsSecret("Y");
        else cs.setCsSecret("N");

        cs.setWriterUserCode(user.getUserCode());

        csService.registCS(cs);

        return "redirect:/cs";
    }

    @GetMapping("/modify")
    public String getCSModifyView(@RequestParam int csCode, Model model) {
        CSDTO cs = csService.getCSDetail(csCode);
        cs.setIsSecret(cs.getCsSecret().equals("Y"));
        model.addAttribute("cs", cs);

        return "cs/modify";
    }

    @PostMapping("/modify")
    public String modifyCS(@ModelAttribute CSDTO cs, @AuthenticationPrincipal UserDTO user) {
        if(cs.getIsSecret()) cs.setCsSecret("Y");
        else cs.setCsSecret("N");

        cs.setWriterUserCode(user.getUserCode());

        csService.modifyCS(cs);
        return "redirect:/cs";
    }

    @ResponseBody
    @PostMapping("/delete")
    public String deleteCS(@RequestBody int csCode) {
        csService.deleteCS(csCode);
        return "성공적으로 삭제되었습니다.";
    }
}
