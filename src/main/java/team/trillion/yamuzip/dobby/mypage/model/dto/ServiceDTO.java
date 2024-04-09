package team.trillion.yamuzip.dobby.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

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
    private Date serviceCreated;
    private String thumbnailUrl;

}