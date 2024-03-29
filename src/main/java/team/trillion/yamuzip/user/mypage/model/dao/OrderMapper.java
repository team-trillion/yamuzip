package team.trillion.yamuzip.user.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDetailDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    int selectOrderCount(Map<String, String> searchMap);

    List<OrderDTO> selectAllOrderList(@Param("userCode") int userCode, @Param("selectCriteria") SelectCriteria selectCriteria);

    OrderDetailDTO selectOrderDetail(int orderCode);
}
