package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.CalcDTO;
import team.trillion.yamuzip.admin.model.dto.CalcDetailDTO;
import team.trillion.yamuzip.admin.model.dto.CalcMonthlyDTO;

import java.util.List;

@Mapper
public interface CalcMapper {
    List<CalcDTO> findAllCalc();

    CalcDetailDTO selectCalcDetail(int orderCode);

    CalcMonthlyDTO selectMonthlyDetail(String selectMonth);

}
