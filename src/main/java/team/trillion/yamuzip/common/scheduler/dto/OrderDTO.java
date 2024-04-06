package team.trillion.yamuzip.common.scheduler.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.OrderStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OrderDTO {
    private int orderCode;
    private String payCode;
    private OrderStatus orderStatus;
    private LocalDateTime reserveDatetime;
}
