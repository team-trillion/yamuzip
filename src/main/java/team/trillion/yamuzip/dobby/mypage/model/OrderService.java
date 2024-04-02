package team.trillion.yamuzip.dobby.mypage.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.common.paging.Pagenation;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.dobby.mypage.model.dao.OrderMapper;
import team.trillion.yamuzip.dobby.mypage.model.dto.OrderCountDTO;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDTO;
import team.trillion.yamuzip.user.mypage.model.dto.OrderDetailDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    public int getDobCode(int userCode) {
        return orderMapper.getDobCode(userCode);
    }

    public OrderCountDTO getOrderCount(int dobCode) {
        return orderMapper.getOrderCount(dobCode);
    }

    public Map<String, Object> selectAllOrderList(int dobCode, Map<String, String> searchMap, int page) {
        searchMap.put("dobCode", String.valueOf(dobCode));
        int totalCount = orderMapper.selectOrderCount(searchMap);

        int limit = 5;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);

        List<OrderDTO> orderList = orderMapper.selectAllOrderList(dobCode, selectCriteria);

        Map<String, Object> orderListAndPaging = new HashMap<>();
        orderListAndPaging.put("paging", selectCriteria);
        orderListAndPaging.put("orderList", orderList);

        return orderListAndPaging;
    }

    public OrderDetailDTO selectOrderDetail(int orderCode) {
        return orderMapper.selectOrderDetail(orderCode);
    }


}
