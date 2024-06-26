package team.trillion.yamuzip.dobby.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.AccountDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyTmpDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.WorkdayDTO;

import java.util.Map;

@Mapper
public interface ModifyMapper {

    void insertDobCode(int userCode);

    ModifyDTO getDobby(int userCode);

    void modifyDobby(ModifyTmpDTO modifyDobby);

    void registWorkday(WorkdayDTO modifyWorkday);

    void deleteWorkday(int dobCode);

//    void deleteWorkday(Map<String, Integer> parameters);

}
