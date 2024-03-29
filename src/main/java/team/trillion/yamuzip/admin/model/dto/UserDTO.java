package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.login.model.Authority;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class UserDTO {

    private int userCode;
    private String userName;
    private String userId;
    private String userNickname;
    private String phone;
    private Date registDatetime;
    private Date quitDatetime;
    private char userStatus;
    private LocalDate unban;
    private String userImg;
    private Authority auth;
    private String email;
}
