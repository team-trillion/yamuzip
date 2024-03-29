package team.trillion.yamuzip.dobby.regist.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class RegistDTO {

    private int applyCode;
    private int userCode;
    private String applyCareer;
    private String applyStatus;
    private LocalDate applyDatetime;

}
