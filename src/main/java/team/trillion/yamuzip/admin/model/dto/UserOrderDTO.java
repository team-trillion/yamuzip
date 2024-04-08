package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.OrderStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserOrderDTO {

    private int orderCode;
    private int userCode;
    private int serviceCode;
    private String thumbnailUrl;
    private String serviceTitle;
    private LocalDateTime orderDatetime;
    private String orderDateString;
    private OrderStatus orderStatus;
    private int totalPrice;

}
