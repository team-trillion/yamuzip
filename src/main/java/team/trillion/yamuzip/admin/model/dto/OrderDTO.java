package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.OrderStatus;
import team.trillion.yamuzip.common.enums.PayStatus;

import java.util.Date;

@Getter
@Setter
@ToString
public class OrderDTO {

    private int orderCode;
    private int payPrice;

    private String serviceTitle;
    private Date orderDatetime;
    private Date payDatetime;

    private OrderStatus orderStatus;
    private PayStatus payStatus;

}
