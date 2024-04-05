package team.trillion.yamuzip.dobby.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyTmpDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.WorkdayDTO;

import java.util.Map;

@Mapper
public interface ModifyMapper {

    ModifyDTO getDobby(int userCode);

    void modifyDobby(ModifyTmpDTO modifyDobby);

    void registWorkday(WorkdayDTO modifyWorkday);

    void deleteWorkday(Map<String, Integer> parameters);
}
