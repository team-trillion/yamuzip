package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.OrderStatus;
import team.trillion.yamuzip.common.enums.PayStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OrderDetailDTO {
    private int orderCode;
    private String serviceTitle;

}
