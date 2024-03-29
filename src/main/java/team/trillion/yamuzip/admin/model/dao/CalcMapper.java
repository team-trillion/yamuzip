package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.CalcDTO;

import java.util.List;

@Mapper
public interface CalcMapper {
    List<CalcDTO> findAllCalc();
}
