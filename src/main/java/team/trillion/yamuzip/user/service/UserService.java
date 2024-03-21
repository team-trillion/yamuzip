package team.trillion.yamuzip.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.user.dao.UserMapper;
import team.trillion.yamuzip.user.dto.UserDTO;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registUser(UserDTO user) {

        user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));
        userMapper.registUser(user);
    }

}
