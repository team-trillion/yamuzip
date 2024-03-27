package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.UserDTO;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDTO> findAllUser();
}
