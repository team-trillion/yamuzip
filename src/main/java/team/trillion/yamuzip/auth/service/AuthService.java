package team.trillion.yamuzip.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.auth.model.CustomUser;
import team.trillion.yamuzip.user.dao.UserMapper;
import team.trillion.yamuzip.user.dto.UserDTO;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserMapper userMapper;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /* 전달 된 id 확인*/
        log.info("username : {}", username);

        UserDTO user = userMapper.login(username);

        /* 조회 된 유저 확인 */
        log.info("user ; {}", user);

        /* 일치하는 아이디가 없어서 조회 된 유저가 없는 경우 */
        if (user == null) throw new UsernameNotFoundException ("userId not found");

        /* 권한 만들기*/
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getAuth().name()));

        // 사용자의 Principal 객체에 닉네임 속성 추가
//        CustomUser customUser = new CustomUser(user, authorities);
//        customUser.setUserNickname(user.getUserNickname());

        return new CustomUser(user, authorities);
    }
}
