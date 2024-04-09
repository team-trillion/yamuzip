package team.trillion.yamuzip.dobby.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ServiceStatusDTO {

    private int serviceCode;
    private String thumbnailUrl;
    private String serviceTitle;
    private Date orderDatetime;
    private int totalPrice;
    private String calStatus;

}
