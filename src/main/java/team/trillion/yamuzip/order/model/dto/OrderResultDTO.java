package team.trillion.yamuzip.order.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderResultDTO {
    private String payCode;
    private String orderCode;
    private int payPrice;
    private String payType;

    private String serviceTitle;
    private String optionName;
    private int optionPrice;
}
