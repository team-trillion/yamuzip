package team.trillion.yamuzip.login.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.login.dto.UserDTO;

import java.util.List;

@Mapper
public interface UserMapper {


    UserDTO login(String userId);
    void regist(UserDTO user);


    List<String> getIds();

    List<String> findId();
}
