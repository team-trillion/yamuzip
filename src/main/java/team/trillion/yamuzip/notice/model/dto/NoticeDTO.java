package team.trillion.yamuzip.notice.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class NoticeDTO {
    private int noticeCode;
    private String noticeTitle;
    private String noticeContent;

    private int writerUserCode;
    private String userNickname;

    private int noticeHits;
    private String noticeFixed;
    private Boolean isFixed;
    private char noticeStatus;

    private LocalDateTime noticeCreated;
    private String noticeCreatedString;
    private LocalDateTime noticeModify;
}
