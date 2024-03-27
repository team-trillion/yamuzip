package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.ServiceDTO;

import java.util.List;

@Mapper
public interface ServiceMapper {
    List<ServiceDTO> findAllService();
}
