package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.login.model.Authority;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
public class UserDTO {

    private int userCode;
    private String userName;
    private String userId;
    private String userNickname;
    private String phone;
    private String userRev;
    private String userCs;
    private Date registDatetime;
    private Date quitDatetime;
    private Date orderDatetime;
    private char userStatus;
    private LocalDateTime unban;
    private String userImg;
    private Authority auth;
    private String email;
}
