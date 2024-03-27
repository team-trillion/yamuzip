package team.trillion.yamuzip.service.model.dto;

import lombok.*;


// @Data 보안상 좋지 않으니 쓰지 마십셔 -김영한
@Getter
@Setter
@ToString
public class DobbyDTO {
    private long dobCode;
    private long user_code;
    private String dobNickName;
    private String dobImage;
    private String dobContent;
    private String dobArea;
    private String dobCareerDays;
}
