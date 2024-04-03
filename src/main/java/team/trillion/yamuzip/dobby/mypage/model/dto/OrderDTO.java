package team.trillion.yamuzip.dobby.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.OrderStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OrderDTO {

    private int orderCode;
    private int userCode;
    private String userId;

    private LocalDateTime orderDatetime;
    private String orderDateString;

    private int serviceCode;
    private String serviceTitle;

    private OrderStatus orderStatus;

}
