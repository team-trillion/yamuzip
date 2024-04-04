package team.trillion.yamuzip.user.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ModifyDTO {

    private String userId;
    private String userImg;
    private String userNickname;
    private String userName;
    private String phone;
    private String email;

}
