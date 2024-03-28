package team.trillion.yamuzip.user.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import team.trillion.yamuzip.user.model.Authority;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

@Getter @Setter @ToString
public class UserDTO implements UserDetails {

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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roleName = "";
        if(auth != null) roleName = auth.name();
        return Arrays.asList(new SimpleGrantedAuthority(roleName));
    }

    @Override
    public String getPassword() {
        return userPwd;
    }

    @Override
    public String getUsername() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
