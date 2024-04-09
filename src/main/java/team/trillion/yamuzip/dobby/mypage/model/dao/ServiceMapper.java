package team.trillion.yamuzip.dobby.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.ServiceDTO;

import java.util.List;

@Mapper
public interface ServiceMapper {

    List<ServiceDTO> getService(int dobCode);

}
