package team.trillion.yamuzip.dobby.mypage.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.dobby.mypage.model.dao.AccountMapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.AccountDTO;
import team.trillion.yamuzip.dobby.mypage.model.dto.ModifyDTO;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountMapper accountMapper;

    // 도비 계좌 조회
    public AccountDTO getAccount(int dobCode) {
        return accountMapper.getAccount(dobCode);
    }

    // 도비 계좌 수정
    public void modifyAccount(AccountDTO modifyDobby) {

        accountMapper.modifyAccount(modifyDobby);
        accountMapper.insertAccount(modifyDobby);

    }
}
