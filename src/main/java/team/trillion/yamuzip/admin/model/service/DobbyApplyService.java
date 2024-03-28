package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.DobbyApplyMapper;
import team.trillion.yamuzip.admin.model.dto.DobbyApplyDTO;

import java.util.List;

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

    public DobbyApplyDTO selectApplyDetail(Long applyCode) {

        return dobbyApplyMapper.selectApplyDetail(applyCode);
    }
}
