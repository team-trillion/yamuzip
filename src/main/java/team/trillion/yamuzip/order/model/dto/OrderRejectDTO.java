package team.trillion.yamuzip.order.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderRejectDTO {
    private int orderCode;
    private String payCode;
    private String rejectReason;
}
