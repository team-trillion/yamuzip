package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.service.model.dto.CsDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CSADTO {

    private long csRepCode;
    private long writerUserCode;
    private LocalDateTime csRepCreated;
    private char csRepStatus;
    private LocalDateTime csRepModify;
    private String csRepContent;
    private CsDTO csCode;

}
