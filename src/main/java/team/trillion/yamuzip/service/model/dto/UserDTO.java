package team.trillion.yamuzip.service.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserDTO {
    private long userCode;
    private String userId;
    private String userPwd;
    private String userName;
    private String userNickname;
    private String phone;
    private LocalDateTime registDatetime;
    private LocalDateTime quitDatetime;
    private char userStatus;
    private LocalDateTime unban;
    private String userImg;
    private String auth;
    private String email;
}
