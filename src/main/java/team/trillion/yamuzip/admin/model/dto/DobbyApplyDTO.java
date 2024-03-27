package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class DobbyApplyDTO {

    private int applyCode;
    private String userId;
    private String userName;
    private String phone;
    private String applyCareer;
    private Date applyDatetime;

}
