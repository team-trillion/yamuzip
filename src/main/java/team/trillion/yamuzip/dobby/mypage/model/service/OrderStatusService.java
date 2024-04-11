package team.trillion.yamuzip.dobby.mypage.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.dobby.mypage.model.dto.OrderStatusDTO;
import team.trillion.yamuzip.dobby.mypage.model.dao.OrderStatusMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderStatusService {

    private final OrderStatusMapper orderStatusMapper;

    public List<OrderStatusDTO> orderStatus(int dobCode) {
        return orderStatusMapper.orderStatus(dobCode);
    }
}
