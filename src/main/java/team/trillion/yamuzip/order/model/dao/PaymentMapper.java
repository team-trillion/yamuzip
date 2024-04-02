package team.trillion.yamuzip.order.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.order.model.dto.OrderCancelDTO;
import team.trillion.yamuzip.order.model.dto.PaymentDTO;

@Mapper
public interface PaymentMapper {

    PaymentDTO getPaymentByOrderCode(int orderCode);

    void cancelPayment(String payCode);

    void cancelOrder(OrderCancelDTO orderCancel);
}
