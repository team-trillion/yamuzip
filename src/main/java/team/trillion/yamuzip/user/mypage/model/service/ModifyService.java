package team.trillion.yamuzip.user.mypage.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.user.mypage.model.dao.ModifyMapper;
import team.trillion.yamuzip.user.mypage.model.dto.ModifyDTO;

@Service
@RequiredArgsConstructor
public class ModifyService {

    private final ModifyMapper modifyMapper;
    public void modifyUser(ModifyDTO modifyUser) {

        modifyMapper.modifyUser(modifyUser);
    }

}
