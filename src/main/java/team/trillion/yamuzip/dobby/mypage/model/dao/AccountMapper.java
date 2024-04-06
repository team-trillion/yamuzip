package team.trillion.yamuzip.dobby.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.AccountDTO;

@Mapper
public interface AccountMapper {

    AccountDTO getAccount(int dobCode);

    void insertAccount(AccountDTO accountDobby);
    void modifyAccount(AccountDTO accountDobby);
}
