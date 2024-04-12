package team.trillion.yamuzip.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.admin.model.dto.OrderDTO;
import team.trillion.yamuzip.admin.model.dto.OrderDetailDTO;
import team.trillion.yamuzip.common.paging.SelectCriteria;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    int getOrderCount(Map<String, String> searchMap);

    List<OrderDTO> getOrderList(SelectCriteria selectCriteria);

    OrderDetailDTO selectOrderDetail(int orderCode);
}
