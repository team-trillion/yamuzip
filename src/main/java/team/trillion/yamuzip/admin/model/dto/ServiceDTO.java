package team.trillion.yamuzip.admin.model.dto;

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
    private String serviceTitle;
    private int categoryCode;
    private Date serviceCreated;
    private String thumbnailUrl;

}
