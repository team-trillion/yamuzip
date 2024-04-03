package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.OrderDTO;
import team.trillion.yamuzip.admin.model.dto.OrderDetailDTO;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDTO> findAllOrder();

    OrderDetailDTO selectOrderDetail(int orderCode);
}
