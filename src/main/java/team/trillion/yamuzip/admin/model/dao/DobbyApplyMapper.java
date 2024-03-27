package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.DobbyApplyDTO;

import java.util.List;

@Mapper
public interface DobbyApplyMapper {
    List<DobbyApplyDTO> findAllApply();
}
