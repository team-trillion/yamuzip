package team.trillion.yamuzip.dobby.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.dobby.model.dao.DobbyRegistMapper;
import team.trillion.yamuzip.dobby.model.dto.DobbyRegistDTO;

@Service
@RequiredArgsConstructor
@RequestMapping("/signup/dobby")

public class DobbyRegistService {

    private final DobbyRegistMapper dobbyRegistMapper;

    public void registDobby(DobbyRegistDTO registDobby) {

        dobbyRegistMapper.registDobby(registDobby);
    }

    public int selectDobbyApplyByUserCode(int userCode) {
        return dobbyRegistMapper.selectDobbyApplyByUserCode(userCode);
    }
}
