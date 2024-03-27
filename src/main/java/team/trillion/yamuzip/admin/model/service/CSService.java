package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.CSMapper;

@Slf4j
@Service
@Transactional
public class CSService {

    private final CSMapper csMapper;

    public CSService(CSMapper csMapper) {
        this.csMapper = csMapper;
    }
}
