package team.trillion.yamuzip.dobby.regist.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.dobby.regist.model.dto.RegistDTO;

@Mapper
public interface RegistMapper {

    void registDobby(RegistDTO registDobby);

    int applyStatus(int userCode);
}
