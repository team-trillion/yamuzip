package team.trillion.yamuzip.user.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.user.dto.UserDTO;

@Mapper
public interface UserMapper {


    UserDTO login(String userId);
    void regist(UserDTO user);
}
