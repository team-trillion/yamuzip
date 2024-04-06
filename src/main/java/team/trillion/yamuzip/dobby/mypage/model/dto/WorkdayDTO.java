package team.trillion.yamuzip.dobby.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WorkdayDTO {
    private int dobCode;
    private int dayWeek;


    // 요일 반환
    public String getDayOfWeek() {
        switch (dayWeek) {
            case 0:
                return "일요일";
            case 1:
                return "월요일";
            case 2:
                return "화요일";
            case 3:
                return "수요일";
            case 4:
                return "목요일";
            case 5:
                return "금요일";
            case 6:
                return "토요일";
            default:
                return "잘못된 요일";
        }
    }
}
