package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.UserMapper;
import team.trillion.yamuzip.admin.model.dto.UserDTO;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
//@Transactional
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserDTO> findAllUser() {
        return userMapper.findAllUser();
    }

    public void banControl(Map<String, Object> banMap) {
        userMapper.banControl(banMap);
    }

    public UserDTO findBanUser(int userCode) {
        return userMapper.findBanUser(userCode);
    }

    public List<UserDTO> findAllBanUser() {
        return userMapper.findAllBanUser();
    }

}
