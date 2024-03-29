package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.DobbyDTO;

import java.util.List;

@Mapper
public interface DobbyMapper {
    List<DobbyDTO> findAllDobby();

    List<DobbyDTO> findDetailDobby(long dobbyCode);
}
