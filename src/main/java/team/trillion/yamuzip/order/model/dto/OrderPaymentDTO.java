package team.trillion.yamuzip.order.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OrderPaymentDTO {
    private int serviceCode;
    private int userCode;
    private int totalPrice;
    private LocalDateTime reserveDatetime;
    private int optionCode;

    private String payCode;
    private String payType;
    private char payStatus;
    private LocalDateTime payDatetime;

}
