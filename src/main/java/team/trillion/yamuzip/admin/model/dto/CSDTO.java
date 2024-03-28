package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.service.model.dto.ServiceDTO;
import team.trillion.yamuzip.service.model.dto.UserDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CSDTO {

    private long csCode;
    private char section;
    private UserDTO user;
    private LocalDateTime csCreated;
    private char csStatus;
    private String csType;
    private char csSecret;
    private LocalDateTime csModify;
    private String csTitle;
    private String csContent;
    private ServiceDTO serviceCode;

}
