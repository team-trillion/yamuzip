package team.trillion.yamuzip.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import team.trillion.yamuzip.login.dao.UserMapper;
import team.trillion.yamuzip.login.dto.UserDTO;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@RequestMapping("")
public class UserService {


    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public void regist(UserDTO user) {
        // 사용자 비밀번호가 null이 아닌지 확인
        if (user.getUserPwd() != null) {
            // 비밀번호를 인코딩하여 설정
            user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));
            // 나머지 로직 수행
            userMapper.regist(user);
        } else {
            // 사용자 비밀번호가 null인 경우 예외 처리 또는 로그 기록
            throw new IllegalArgumentException("User password cannot be null");
        }
    }


    public List<String> getIds() {
        return userMapper.getIds();
    }



    public List<String> findUserId(String name, String email) {
        List<String> userIdList = userMapper.findUserId(name, email);
        return userIdList.isEmpty() ? Collections.emptyList() : userIdList;
    }



}
