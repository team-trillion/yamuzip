package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.DobbyApplyDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface DobbyApplyMapper {
    List<DobbyApplyDTO> findAllApply();

    DobbyApplyDTO selectApplyDetail(int applyCode);

    void applyControl(Map<String, Object> applyMap);
    void addDobby(Map<String, Object> applyMap);
}
