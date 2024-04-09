package team.trillion.yamuzip.cs.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CSReplyDTO {
    private int csRepCode;
    private String csRepContent;

    private LocalDateTime csRepCreated;
    private String csRepCreatedString;

    private String csRepStatus;
    private int csCode;
    private int writerUserCode;
    private String userNickname;
    private LocalDateTime csRepModify;
}
