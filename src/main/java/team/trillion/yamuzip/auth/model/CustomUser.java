package team.trillion.yamuzip.auth.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import team.trillion.yamuzip.user.dto.UserDTO;

import java.util.Collection;
import java.util.List;

@Getter
@ToString
public class CustomUser extends User {

    private int userCode;
    private String userName;
//    private String userNickname;



    public CustomUser(UserDTO user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getUserPwd(), authorities);
        this.userCode = user.getUserCode();
        this.userName = user.getUsername();
    }

    @Override
    public String toString() {
        return super.toString() + ", userCode :" + userCode + ", userId : " + userName;
    }

//    public CustomUser(UserDTO user, List<GrantedAuthority> authorities) {
//        super(user.getUserId(), user.getUserPwd(), authorities);
//        this.userNickname = user.getUserNickname(); // 사용자의 닉네임 설정
//        // 다른 필드들 설정
//    }

//    public String getUserNickname() {
//        return userNickname;
//    }
//
//    public void setUserNickname(String nickname) {
//        this.userNickname = userNickname;
//    }
}

