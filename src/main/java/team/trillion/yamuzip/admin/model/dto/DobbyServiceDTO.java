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
public class DobbyServiceDTO {

    private int userCode;
    private int dobCode;
    private int serviceCode;
    private String thumbnailUrl;
    private String serviceTitle;
    private LocalDateTime serviceCreated;
    private String serviceDateString;
    private int servicePrice;
    private OrderStatus orderStatus;

}
