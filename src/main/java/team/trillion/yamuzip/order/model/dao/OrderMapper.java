package team.trillion.yamuzip.order.model.dao;

import org.apache.ibatis.annotations.Mapper;
import team.trillion.yamuzip.order.model.dto.*;

@Mapper
public interface OrderMapper {
    ServiceDTO selectService(int serviceCode);

    OptionDTO selectOption(int optionCode);

    void insertOrder(OrderDTO order);

    void insertOrderNoOption(OrderDTO order);

    void insertPayment(PaymentDTO payment);

    OrderResultDTO selectOrderResult(String payCode);
}
