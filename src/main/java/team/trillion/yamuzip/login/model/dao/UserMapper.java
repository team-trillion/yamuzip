package team.trillion.yamuzip.login.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import team.trillion.yamuzip.login.model.dto.UserDTO;

import java.util.List;

@Mapper
public interface UserMapper {

    UserDTO login(String userId);
    void regist(UserDTO user);


    List<String> getIds();


    List<String> findUserId(@Param("name") String name, @Param("email") String email);


}
