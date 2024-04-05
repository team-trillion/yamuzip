package team.trillion.yamuzip.user.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.OrderStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ReviewDTO {
    private int reviewCode;
    private int orderCode;
    private int userCode;
    private int serviceCode;
    private String thumbnailUrl;
    private String serviceTitle;
    private LocalDateTime reviewDatetime;
    private String reviewDateString;
    private OrderStatus orderStatus;
    private int totalPrice;
    private String reviewContent;
    private double reviewGrade;
}
