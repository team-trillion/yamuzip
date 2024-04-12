package team.trillion.yamuzip.service.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CsDTO {
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
private String writerUserCode;
}


