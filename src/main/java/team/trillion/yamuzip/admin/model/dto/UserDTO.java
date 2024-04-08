package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.UserAuth;

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
    private UserAuth auth;
    private String area;
    private String email;
}
