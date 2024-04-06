package team.trillion.yamuzip.dobby.mypage.model.dto;

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
    private String serviceExplain;
    private String serviceContent;
    private String servicePrice;
    private String serviceStatus;
    private String serviceCreated;
    private String thumbnailUrl;

}