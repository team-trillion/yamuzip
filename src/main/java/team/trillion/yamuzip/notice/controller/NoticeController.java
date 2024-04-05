package team.trillion.yamuzip.notice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.trillion.yamuzip.login.model.dto.UserDTO;
import team.trillion.yamuzip.notice.model.dto.NoticeDTO;
import team.trillion.yamuzip.notice.model.service.NoticeService;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping
    public String getNoticeList(@RequestParam(defaultValue = "1") int page,
                                Model model) {

        Map<String, Object> noticeListAndPaging = noticeService.getNoticeList(page);
        model.addAttribute("paging", noticeListAndPaging.get("paging"));

        List<NoticeDTO> fixedList = noticeService.getFixedList();
        for(NoticeDTO notice : fixedList) {
            notice.setNoticeCreatedString(notice.getNoticeCreated().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
        model.addAttribute("fixedList", fixedList);

        List<NoticeDTO> noticeList = (List<NoticeDTO>) noticeListAndPaging.get("noticeList");
        for(NoticeDTO notice : noticeList) {
            notice.setNoticeCreatedString(notice.getNoticeCreated().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
        model.addAttribute("noticeList", noticeList);
        return "notice/notice";
    }

    @GetMapping("/detail")
    public String getNoticeDetail(@RequestParam int noticeCode, Model model) {
        NoticeDTO notice = noticeService.getNoticeDetail(noticeCode);
        notice.setNoticeCreatedString(notice.getNoticeCreated().format(DateTimeFormatter.ISO_LOCAL_DATE));
        model.addAttribute("notice", notice);

        return "notice/detail";
    }

    @GetMapping("/regist")
    public String getNoticeRegistView() {
        return "notice/regist";
    }

    @PostMapping("/regist")
    public String registNotice(@ModelAttribute NoticeDTO notice, @AuthenticationPrincipal UserDTO user) {
        if(notice.getIsFixed()) notice.setNoticeFixed("Y");
        else notice.setNoticeFixed("N");

        notice.setWriterUserCode(user.getUserCode());

        noticeService.registNotice(notice);

        return "redirect:/notice";
    }

    @GetMapping("/modify")
    public String getNoticeModifyView(@RequestParam int noticeCode, Model model) {
        NoticeDTO notice = noticeService.getNoticeDetail(noticeCode);
        if(notice.getNoticeFixed().equals("Y")) notice.setIsFixed(true);
        model.addAttribute("notice", notice);

        return "notice/modify";
    }

    @PostMapping("/modify")
    public String modifyNotice(@ModelAttribute NoticeDTO notice, @AuthenticationPrincipal UserDTO user) {
        if(notice.getIsFixed()) notice.setNoticeFixed("Y");
        else notice.setNoticeFixed("N");

        notice.setWriterUserCode(user.getUserCode());

        noticeService.modifyNotice(notice);
        return "redirect:/notice";
    }

    @ResponseBody
    @PostMapping("/delete")
    public String deleteNotice(@RequestBody int noticeCode) {
        noticeService.deleteNotice(noticeCode);
        return "성공적으로 삭제되었습니다.";
    }
}
