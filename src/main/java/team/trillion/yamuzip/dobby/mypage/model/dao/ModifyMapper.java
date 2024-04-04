package team.trillion.yamuzip.dobby.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;

@Mapper
public interface ModifyMapper {

    ModifyDTO getDobby(int userCode);

    void modifyDobby(ModifyDTO modifyDobby);
}
