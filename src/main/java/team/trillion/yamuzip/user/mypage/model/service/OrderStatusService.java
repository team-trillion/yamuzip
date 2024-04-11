package team.trillion.yamuzip.user.mypage.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.user.mypage.model.dao.OrderStatusMapper;
import team.trillion.yamuzip.user.mypage.model.dto.OrderStatusDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderStatusService {

    private final OrderStatusMapper orderStatusMapper;

    public List<OrderStatusDTO> orderStatus(int userCode) {
        return orderStatusMapper.orderStatus(userCode);
    }
}
