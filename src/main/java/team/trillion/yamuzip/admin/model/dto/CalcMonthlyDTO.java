package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CalcMonthlyDTO {

    private String selectMonth;

    private int dobResult;
    private int userResult;
    private int payResult;

    private int payCount;
    private int chargeResult;
    private int salesResult;

    private int cancelCount;
    private int cancelResult;

}
