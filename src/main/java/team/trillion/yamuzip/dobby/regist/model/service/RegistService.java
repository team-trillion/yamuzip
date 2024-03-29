package team.trillion.yamuzip.dobby.regist.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.dobby.regist.model.dao.RegistMapper;
import team.trillion.yamuzip.dobby.regist.model.dto.RegistDTO;

@Service
@RequiredArgsConstructor
@RequestMapping("/signup/dobby")

public class RegistService {

    private final RegistMapper registMapper;

    public void registDobby(RegistDTO registDobby) {

        registMapper.registDobby(registDobby);
    }

    public int selectApplyStatus(int userCode) { return registMapper.applyStatus(userCode);}

}
