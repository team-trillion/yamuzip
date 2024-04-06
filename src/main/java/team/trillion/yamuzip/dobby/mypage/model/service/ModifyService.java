package team.trillion.yamuzip.dobby.mypage.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.dobby.mypage.model.dao.ModifyMapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyTmpDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.WorkdayDTO;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ModifyService {

    private final ModifyMapper modifyMapper;

    // 도비 프로필 정보 조회
    public ModifyDTO getDobby(int userCode) {
        return modifyMapper.getDobby(userCode);
    }


    // 도비 정보 수정
    public void modifyDobby(ModifyTmpDTO modifyDobby) {

        modifyMapper.modifyDobby(modifyDobby);

    }

    // 도비 WORKDAY 수정
    public void registWorkday(WorkdayDTO registWorkday) {

        modifyMapper.registWorkday(registWorkday);

    }

    // 도비 WORKDAY 삭제

    public void deleteWorkday(int dobCode, int dayWeek) {
        Map<String, Integer> workday = new HashMap<>();
        workday.put("dobCode", dobCode);
        workday.put("dayWeek", dayWeek);
        modifyMapper.deleteWorkday(workday);
    }


}
