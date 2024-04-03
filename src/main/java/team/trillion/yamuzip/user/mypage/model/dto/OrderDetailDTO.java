package team.trillion.yamuzip.user.mypage.model.dto;

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
    private LocalDateTime orderDatetime;
    private String orderDateString;
    private int userCode;
    private String userName;
    private OrderStatus orderStatus;

    private PayType payType;
    private PayStatus payStatus;
    private String payStatusString;
    private int servicePrice;
    private int optionPrice;
    private int totalPrice;

    private String thumbnailUrl;
    private String serviceTitle;
    private String optionName;

    private LocalDateTime reserveDatetime;
    private String reserveDateString;

    private LocalDateTime rejectDatetime;
    private String rejectDateString;
    private String rejectReason;

    private LocalDateTime cancelDatetime;
    private String cancelDateString;
    private String cancelReason;

}
