package team.trillion.yamuzip.dobby.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDTO {
    private int dobCode;
    private int accCode;
    private String accNumber;
    private String accBank;
    private String accName;
    private String accStatus;
}
