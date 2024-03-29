package team.trillion.yamuzip.login.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.login.model.Authority;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class UserDTO {

    private int userCode;
    private String userId;
    private String userPwd;
    private String userPwdConfirm;
    private String userName;
    private String userNickname;
    private String phone;
    private LocalDate registDatetime;
    private LocalDate quitDatetime;
    private char userStatus;
    private LocalDate unban;
    private String userImg;
    private Authority auth;
    private String email;
}
