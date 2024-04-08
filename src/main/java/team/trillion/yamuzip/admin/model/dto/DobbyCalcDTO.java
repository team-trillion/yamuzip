package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
public class DobbyCalcDTO {

    private int orderCode;
    private int calPrice;
    private int totalPrice;
    private int serviceCode;

    private LocalDateTime payDatetime;
    private String payDateString;

    private String serviceTitle;
    private String userNickname;
    private String thumbnailUrl;

    private int calStatus;

}
