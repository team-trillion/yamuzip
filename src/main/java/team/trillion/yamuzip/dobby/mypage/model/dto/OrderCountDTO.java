package team.trillion.yamuzip.dobby.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderCountDTO {

    private int orderCount;
    private int approveCount;
    private int finishCount;
}
