package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.CalcMapper;

@Slf4j
@Service
@Transactional
public class CalcService {

    private final CalcMapper calcMapper;

    public CalcService(CalcMapper calcMapper) {
        this.calcMapper = calcMapper;
    }

}
