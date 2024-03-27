package team.trillion.yamuzip.order.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OrderDTO {

    private int orderCode;
    private int serviceCode;
    private int userCode;
    private LocalDateTime orderDatetime;
    // private char orderStatus;
    private int totalPrice;
    private LocalDateTime reserveDatetime;
    private int optionCode;
    private LocalDateTime approvalDatetime;
    private LocalDateTime cancelDatetime;
    private LocalDateTime rejectDatetime;
    private String cancelReason;
    private String rejectReason;

}
