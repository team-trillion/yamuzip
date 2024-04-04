package team.trillion.yamuzip.dobby.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.WorkdayDTO;

@Mapper
public interface ModifyMapper {

    
    void modifyDobby(ModifyDTO modifyDobby);

    ModifyDTO getDobby(int userCode);

}
