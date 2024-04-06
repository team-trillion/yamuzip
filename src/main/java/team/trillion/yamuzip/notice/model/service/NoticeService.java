package team.trillion.yamuzip.notice.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.common.paging.Pagenation;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.notice.model.dao.NoticeMapper;
import team.trillion.yamuzip.notice.model.dto.NoticeDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper noticeMapper;

    public List<NoticeDTO> getFixedList() {
        return noticeMapper.getFixedList();
    }

    public Map<String, Object> getNoticeList(int page) {
        int totalCount = noticeMapper.getNoticeCount();

        int limit = 10;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
        List<NoticeDTO> noticeList = noticeMapper.getNoticeList(selectCriteria);

        Map<String, Object> noticeListAndPaging = new HashMap<>();
        noticeListAndPaging.put("paging", selectCriteria);
        noticeListAndPaging.put("noticeList", noticeList);

        return noticeListAndPaging;
    }

    public NoticeDTO getNoticeDetail(int noticeCode) {
        noticeMapper.incrementNoticeHits(noticeCode);
        return noticeMapper.getNoticeDetail(noticeCode);
    }

    @Transactional
    public void registNotice(NoticeDTO notice) {
        noticeMapper.registNotice(notice);
    }

    @Transactional
    public void modifyNotice(NoticeDTO notice) {
        noticeMapper.modifyNotice(notice);
    }

    @Transactional
    public int deleteNotice(int noticeCode) {
        return noticeMapper.deleteNotice(noticeCode);
    }

    @Transactional
    public boolean deleteNotices(List<Integer> noticeCodes) {
        int result = 0;
        for(Integer noticeCode : noticeCodes) {
            result += noticeMapper.deleteNotice(noticeCode);
        }
        return result == noticeCodes.size();
    }
}
