package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ChartDTO {

    private int userCount;
    private LocalDateTime registDate;
    private String registDateString;

}
