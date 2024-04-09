package team.trillion.yamuzip.main.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import team.trillion.yamuzip.notice.model.dto.NoticeDTO;
import team.trillion.yamuzip.notice.model.service.NoticeService;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final NoticeService noticeService;

    @GetMapping(value = {"/main","/"})
    public String defaultRequest(Model model) {
        List<NoticeDTO> noticeList = noticeService.getMainNotice();
        for(NoticeDTO notice : noticeList) {
            notice.setNoticeCreatedString(notice.getNoticeCreated().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        model.addAttribute("noticeList", noticeList);
        return "main";
    }

    @GetMapping("/admin")
    public String ex() {
        return "admin/dashboard/dashboard";
    }

//    @GetMapping("/regist")
//    public String sadf() {return "user/regist";}

//    @GetMapping("/login")
//    public String getLoginPage() {return "user/login";}


//    @GetMapping("/user/findId")
//    public String findId() {return "/user/findId";}

//    @GetMapping("/user/findPwd")
//    public String findPwd() {return "user/findPwd";}

}

