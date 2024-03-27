package team.trillion.yamuzip.service.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OptionDTO {
    private long optionCode;
    private String optionName;
    private long optionPrice;
    private ServiceDTO serviceCode;

}
