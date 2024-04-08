package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.DobbyApplyMapper;
import team.trillion.yamuzip.admin.model.dao.DobbyMapper;
import team.trillion.yamuzip.admin.model.dto.*;
import team.trillion.yamuzip.common.paging.Pagenation;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.service.model.dto.ServiceDTO;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.user.mypage.model.dto.ReviewDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class DobbyService {

    private final DobbyMapper dobbyMapper;

    public DobbyService(DobbyApplyMapper dobbyApplyMapper, DobbyMapper dobbyMapper) {
        this.dobbyMapper = dobbyMapper;
    }

    public List<DobbyDTO> findAllDobby() {
        return dobbyMapper.findAllDobby();
    }

    public DobbyDTO findDetailDobby(int dobCode) {
        return dobbyMapper.findDetailDobby(dobCode);
    }

    public Map<String, Object> selectAllServiceList(int dobCode, Map<String, String> searchMap, int page) {
        searchMap.put("dobCode", String.valueOf(dobCode));
        int totalCount = dobbyMapper.selectServiceCount(searchMap);

        int limit = 5;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
        List<DobbyServiceDTO> serviceList = dobbyMapper.selectAllServiceList(dobCode, selectCriteria);

        Map<String, Object> serviceListAndPaging = new HashMap<>();
        serviceListAndPaging.put("paging", selectCriteria);
        serviceListAndPaging.put("serviceList", serviceList);

        return serviceListAndPaging;
    }

    public Map<String, Object> selectAllCalcList(int dobCode, int page) {
        int totalCount = dobbyMapper.getCalcCount();

        int limit = 5;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
        List<DobbyCalcDTO> calcList = dobbyMapper.getCalcList(dobCode, selectCriteria);

        Map<String, Object> calcListAndPaging = new HashMap<>();
        calcListAndPaging.put("paging", selectCriteria);
        calcListAndPaging.put("calcList", calcList);

        return calcListAndPaging;
    }
}
