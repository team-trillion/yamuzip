package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.OrderStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ChartDTO {

    // 가입자 차트
    private int userCount;
    private LocalDateTime registDate;
    private String registDateString;

    // 카테고리별 판매 차트
    private int orderCount;
    private String categoryName;

    // 최근 한달 결제 차트
    private int statusCount;
    private String statusName;

}
