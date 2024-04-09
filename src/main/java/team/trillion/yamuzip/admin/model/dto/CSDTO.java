package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CSDTO {
    private int csCode;
    private String csTitle;
    private String csContent;

    private int writerUserCode;
    private String userNickname;

    private String section;
    private String csStatus;
    private String csType;
    private String csSecret;
    private Boolean isSecret;

    private LocalDateTime csCreated;
    private String csCreatedString;
    private LocalDateTime csModify;
}
