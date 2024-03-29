package team.trillion.yamuzip.dobby.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.dobby.model.dto.DobbyRegistDTO;

@Mapper
public interface DobbyRegistMapper {

    void registDobby(DobbyRegistDTO registDobby);

    int selectDobbyApplyByUserCode(int userCode);
}
