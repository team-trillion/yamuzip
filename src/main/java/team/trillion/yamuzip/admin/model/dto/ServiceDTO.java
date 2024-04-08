package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.ServiceStatus;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
public class ServiceDTO {

    private int serviceCode;
    private int orderStatus;
    private String dobNickname;
    private String serviceTitle;
    private ServiceStatus serviceStatus;
    private Date serviceCreated;
    private String thumbnailUrl;

}
