package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
public class CalcDTO {

    private String selectMonth;

    // 금액
    private int orderCode;
    private int calPrice;
    private int payPrice;

    // 정보
    private int accCode;
    private String accNumber;
    private String accBank;
    private String accName;
    private String userName;
    private Date reserveDatetime;
    private Date payDatetime;
    private Date orderDatetime;

    // 서비스
    private String serviceTitle;

    // 상태
    private char orderStatus;
    private String payStatus;
    private int calStatus;


}
