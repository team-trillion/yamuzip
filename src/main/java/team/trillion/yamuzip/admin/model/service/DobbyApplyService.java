package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.DobbyApplyMapper;

@Slf4j
@Service
@Transactional
public class DobbyApplyService {

    private final DobbyApplyMapper dobbyApplyMapper;

    public DobbyApplyService(DobbyApplyMapper dobbyApplyMapper) {
        this.dobbyApplyMapper = dobbyApplyMapper;
    }
}
