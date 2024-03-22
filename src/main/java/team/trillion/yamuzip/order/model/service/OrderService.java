package team.trillion.yamuzip.order.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.trillion.yamuzip.order.model.dao.OrderMapper;
import team.trillion.yamuzip.order.model.dto.OptionDTO;
import team.trillion.yamuzip.order.model.dto.OrderDTO;
import team.trillion.yamuzip.order.model.dto.PaymentDTO;
import team.trillion.yamuzip.order.model.dto.ServiceDTO;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    public ServiceDTO selectService(int serviceCode) {
        return orderMapper.selectService(serviceCode);
    }

    public OptionDTO selectOption(int optionCode) {
        return orderMapper.selectOption(optionCode);
    }

    public OrderDTO insertOrder(OrderDTO order) {
        if(order.getOptionCode() == 0) {
            orderMapper.insertOrderNoOption(order);
        } else {
            orderMapper.insertOrder(order);
        }
        return order;
    }

    public void insertPayment(PaymentDTO payment) {
        orderMapper.insertPayment(payment);
    }
}
