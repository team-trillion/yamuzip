package team.trillion.yamuzip.order.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PaymentDTO {
    private String payCode;
    private int orderCode;
    private int payPrice;
    private String payType;
    private char payStatus;
    private LocalDateTime payDatetime;

}
