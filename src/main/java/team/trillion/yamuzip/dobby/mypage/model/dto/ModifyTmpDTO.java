package team.trillion.yamuzip.dobby.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ModifyTmpDTO {

    private int dobCode;
    private int userCode;
    private String dobNickname;
    private String dobImg;
    private String dobContent;
    private String dobArea;
    private String dobCareerDays;
    private String applyCareer;
    private List<String> workdayList;

}
