package team.trillion.yamuzip.dobby.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.OrderStatusDTO;

import java.util.List;

@Mapper
public interface OrderStatusMapper {
    List<OrderStatusDTO> orderStatus(int dobCode);

}
