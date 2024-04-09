package team.trillion.yamuzip.dobby.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CalculateDTO {

    /* 출금 가능 금액 */
    private int totalAvailablePrice;

    /* 출금 완료 금액 */
    private int totalCompletedPrice;

}
