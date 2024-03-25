package team.trillion.yamuzip.order.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OptionDTO {

    private int optionCode;
    private String optionName;
    private int optionPrice;
    private int serviceCode;

}
