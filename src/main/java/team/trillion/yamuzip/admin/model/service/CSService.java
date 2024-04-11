package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.CSMapper;
import team.trillion.yamuzip.common.paging.Pagenation;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.admin.model.dto.CSDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class CSService {

    private final CSMapper csMapper;

    public CSService(CSMapper csMapper) {
        this.csMapper = csMapper;
    }

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

}
