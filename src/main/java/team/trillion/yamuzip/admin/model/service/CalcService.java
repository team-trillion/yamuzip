package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.CalcMapper;
import team.trillion.yamuzip.admin.model.dto.CalcDTO;
import team.trillion.yamuzip.admin.model.dto.CalcDetailDTO;
import team.trillion.yamuzip.admin.model.dto.CalcMonthlyDTO;

import java.util.List;

@Slf4j
@Service
@Transactional
public class CalcService {

    private final CalcMapper calcMapper;

    public CalcService(CalcMapper calcMapper) {
        this.calcMapper = calcMapper;
    }

    public List<CalcDTO> findAllCalc(String selectMonth) {
        return calcMapper.findAllCalc(selectMonth);
    }

    public CalcDetailDTO selectCalcDetail(int orderCode) {

        return calcMapper.selectCalcDetail(orderCode);
    }

    public CalcMonthlyDTO selectMonthlyDetail(String selectMonth) {

        return calcMapper.selectMonthlyDetail(selectMonth);
    }

    public List<CalcDTO> createExcel(String selectMonth) {

        return calcMapper.findAllCalc(selectMonth);
    }
}
