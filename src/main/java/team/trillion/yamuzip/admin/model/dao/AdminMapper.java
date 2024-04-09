package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.ChartDTO;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<ChartDTO> selectWeeklyRegist();

}
