package team.trillion.yamuzip.admin.model.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.admin.model.dao.OrderMapper;
import team.trillion.yamuzip.admin.model.dto.OrderDTO;
import team.trillion.yamuzip.admin.model.dto.OrderDetailDTO;

import java.util.List;

@Slf4j
@Service
@Transactional
public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> findAllOrder() {

        return orderMapper.findAllOrder();
    }

    public OrderDetailDTO selectOrderDetail(int orderCode) {

        return orderMapper.selectOrderDetail(orderCode);
    }
}
