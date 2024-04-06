package team.trillion.yamuzip.user.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceDTO {
    private int serviceCode;
    private int dobCode;
    private int categoryCode;
    private String serviceTitle;
    private String servicePrice;
    private String serviceStatus;

}
