package team.trillion.yamuzip.dobby.mypage.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.dobby.mypage.model.dao.ModifyMapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;

@Service
@RequiredArgsConstructor
public class ModifyService {

    private final ModifyMapper modifyMapper;

    // 도비 프로필 정보 조회
    public ModifyDTO getDobby(int userCode) {
        return modifyMapper.getDobby(userCode);
    }


    // 도비 정보 수정
    public void modifyDobby(ModifyDTO modifyDobby) {

        modifyMapper.modifyDobby(modifyDobby);

    }



}
