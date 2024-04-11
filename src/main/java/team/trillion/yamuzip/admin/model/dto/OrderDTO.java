package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.OrderStatus;
import team.trillion.yamuzip.common.enums.PayStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OrderDTO {

    private int orderCode;
    private int serviceCode;

    private String serviceTitle;
    private int totalPrice;
    private int userCode;
    private String userId;

    private LocalDateTime orderDatetime;
    private String orderDateString;
    private OrderStatus orderStatus;
    private PayStatus payStatus;
}
