package team.trillion.yamuzip.service.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class OptionDTO {
    private long optionCode;
    private String optionName;
    private int optionPrice;
    private long serviceCode;


}
