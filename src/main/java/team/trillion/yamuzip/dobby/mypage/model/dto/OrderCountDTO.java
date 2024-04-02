package team.trillion.yamuzip.dobby.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderCountDTO {

    private int orderCount;
    private int acceptCount;
    private int finishCount;
}
