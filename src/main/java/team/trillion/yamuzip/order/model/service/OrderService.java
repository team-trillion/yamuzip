package team.trillion.yamuzip.order.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.trillion.yamuzip.common.exception.OrderFailedException;
import team.trillion.yamuzip.order.model.dao.OrderMapper;
import team.trillion.yamuzip.order.model.dto.*;

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

    @Transactional
    public void insertOrderInfo(OrderDTO order, PaymentDTO payment) throws OrderFailedException {
        int result1 = 0;
        if(order.getOptionCode() == 0) {
            result1 = orderMapper.insertOrderNoOption(order);
        } else {
            result1 = orderMapper.insertOrder(order);
        }
        payment.setOrderCode(order.getOrderCode());
        int result2 = orderMapper.insertPayment(payment);

        if(!(result1 > 0) && !(result2 > 0)) throw new OrderFailedException();
    }

    public OrderResultDTO selectOrderResult(String payCode) {
        return orderMapper.selectOrderResult(payCode);
    }
}
