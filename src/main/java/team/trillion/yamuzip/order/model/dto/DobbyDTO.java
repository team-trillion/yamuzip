package team.trillion.yamuzip.order.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DobbyDTO {

    private int dobCode;
    private int userCode;
    private String dobNickname;
    private String dobImg;
    private String dobContent;
    private String dobArea;
    private String dobCareerDays;
    // private List<Integer> workdayList;
    private List<WorkdayDTO> workdayList;

}
