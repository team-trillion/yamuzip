package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.DobbyApplyMapper;
import team.trillion.yamuzip.admin.model.dto.DobbyApplyDTO;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class DobbyApplyService {

    private final DobbyApplyMapper dobbyApplyMapper;

    public DobbyApplyService(DobbyApplyMapper dobbyApplyMapper) {
        this.dobbyApplyMapper = dobbyApplyMapper;
    }

    public List<DobbyApplyDTO> findAllApply() {
        return dobbyApplyMapper.findAllApply();
    }

    public void applyControl(Map<String, Object> applyMap) {
        dobbyApplyMapper.applyControl(applyMap);
        if(applyMap.get("result").equals("A"))
            dobbyApplyMapper.addDobby(applyMap);
    }
}
