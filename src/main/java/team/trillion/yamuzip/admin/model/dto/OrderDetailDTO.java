package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.OrderStatus;
import team.trillion.yamuzip.common.enums.PayStatus;
import team.trillion.yamuzip.common.enums.PayType;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OrderDetailDTO {

    private int orderCode;
    private int serviceCode;

    private String serviceTitle;
    private String thumbnailUrl;
    private int totalPrice;
    private PayType payType;

    private int userCode;
    private String userName;
    private String userId;

    private LocalDateTime orderDatetime;
    private String orderDateString;
    private LocalDateTime reserveDatetime;
    private String reserveDateString;
    private LocalDateTime cancelDatetime;
    private String cancelDateString;
    private LocalDateTime rejectDatetime;
    private String rejectDateString;

    private OrderStatus orderStatus;
    private PayStatus payStatus;

}
