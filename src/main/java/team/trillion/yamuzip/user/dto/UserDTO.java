package team.trillion.yamuzip.user.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.user.model.Authority;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class UserDTO {

    private int userCode;
    private String userId;
    private String userPwd;
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
