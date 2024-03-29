package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.DobbyApplyMapper;
import team.trillion.yamuzip.admin.model.dao.DobbyMapper;
import team.trillion.yamuzip.admin.model.dto.DobbyDTO;

import java.util.List;

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

    public List<DobbyDTO> findDetailDobby(long dobbyCode) {
        return dobbyMapper.findDetailDobby(dobbyCode);
    }
}
