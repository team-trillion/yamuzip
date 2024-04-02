package team.trillion.yamuzip.dobby.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.dobby.mypage.model.dto.OrderCountDTO;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDetailDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    int selectOrderCount(Map<String, String> searchMap);

    List<OrderDTO> selectAllOrderList(int dobCode, SelectCriteria selectCriteria);

    int getDobCode(int userCode);

    OrderCountDTO getOrderCount(int dobCode);

    OrderDetailDTO selectOrderDetail(int orderCode);
}
