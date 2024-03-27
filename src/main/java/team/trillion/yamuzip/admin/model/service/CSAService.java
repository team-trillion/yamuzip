package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.CSAMapper;

@Slf4j
@Service
@Transactional
public class CSAService {

    private final CSAMapper csaMapper;

    public CSAService(CSAMapper csaMapper) {
        this.csaMapper = csaMapper;
    }
}
