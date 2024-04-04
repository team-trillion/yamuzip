package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.UserDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<UserDTO> findAllUser();

    void banControl(Map<String, Object> banMap);

    UserDTO findBanUser(int userCode);

    List<UserDTO> findAllBanUser();

}
