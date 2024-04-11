package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.common.paging.SelectCriteria;
import team.trillion.yamuzip.admin.model.dao.OrderMapper;
import team.trillion.yamuzip.admin.model.dto.OrderDTO;
import team.trillion.yamuzip.admin.model.dto.OrderDetailDTO;
import team.trillion.yamuzip.common.paging.Pagenation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    public Map<String, Object> getOrderList(Map<String, String> searchMap, int page) {
        int totalCount = orderMapper.getOrderCount(searchMap);

        int limit = 10;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
        List<OrderDTO> orderList = orderMapper.getOrderList(selectCriteria);

        Map<String, Object> orderListAndPaging = new HashMap<>();
        orderListAndPaging.put("paging", selectCriteria);
        orderListAndPaging.put("orderList", orderList);

        return orderListAndPaging;
    }

    public OrderDetailDTO selectOrderDetail(int orderCode) {

        return orderMapper.selectOrderDetail(orderCode);
    }
}
