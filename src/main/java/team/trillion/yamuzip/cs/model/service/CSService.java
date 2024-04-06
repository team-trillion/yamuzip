package team.trillion.yamuzip.cs.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.common.paging.Pagenation;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.cs.model.dao.CSMapper;
import team.trillion.yamuzip.cs.model.dto.CSDTO;
import team.trillion.yamuzip.notice.model.dao.NoticeMapper;
import team.trillion.yamuzip.notice.model.dto.NoticeDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CSService {
    private final CSMapper csMapper;

    public Map<String, Object> getCSList(int page) {
        int totalCount = csMapper.getCSCount();

        int limit = 10;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
        List<CSDTO> csList = csMapper.getCSList(selectCriteria);

        Map<String, Object> csListAndPaging = new HashMap<>();
        csListAndPaging.put("paging", selectCriteria);
        csListAndPaging.put("csList", csList);

        return csListAndPaging;
    }

    public CSDTO getCSDetail(int csCode) {
        return csMapper.getCSDetail(csCode);
    }

    @Transactional
    public void registCS(CSDTO cs) {
        csMapper.registCS(cs);
    }

    @Transactional
    public void modifyCS(CSDTO cs) {
        csMapper.modifyCS(cs);
    }

    public void deleteCS(int csCode) {
        csMapper.deleteCS(csCode);
    }

    // @Transactional
    // public void deleteNotice(int noticeCode) {
    //     noticeMapper.deleteNotice(noticeCode);
    // }

}
