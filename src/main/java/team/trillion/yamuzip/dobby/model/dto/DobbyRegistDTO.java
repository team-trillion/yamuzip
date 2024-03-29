package team.trillion.yamuzip.dobby.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class DobbyRegistDTO {

    private int applyCode;
    private int userCode;
    private String applyCareer;
    private LocalDate applyDatetime;

}
