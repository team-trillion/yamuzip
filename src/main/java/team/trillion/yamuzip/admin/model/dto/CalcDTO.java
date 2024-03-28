package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CalcDTO {

    private int orderCode;
    private int calPrice;
    private int totalPrice;
    private String userName;
    private int accCode;
    private String accNumber;
    private String accBank;
    private String accName;
    private LocalDateTime reserveDatetime;
    private LocalDateTime calDatetime;

}
