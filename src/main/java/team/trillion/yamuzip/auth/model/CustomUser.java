package team.trillion.yamuzip.auth.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import team.trillion.yamuzip.login.model.dto.UserDTO;

import java.util.Collection;

@Getter
@ToString
public class CustomUser extends User {

    private int userCode;
    private String userName;



    public CustomUser(UserDTO user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getUserPwd(), authorities);
        this.userCode = user.getUserCode();
        this.userName = user.getUsername();
    }

    @Override
    public String toString() {
        return super.toString() + ", userCode :" + userCode + ", userId : " + userName;
    }


}

