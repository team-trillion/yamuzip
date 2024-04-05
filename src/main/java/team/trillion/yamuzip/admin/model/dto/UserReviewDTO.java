package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.trillion.yamuzip.common.enums.OrderStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserReviewDTO {

    private int reviewCode;
    private int orderCode;
    private int writerUserCode;
    private int serviceCode;
    private String userNickname;
    private String thumbnailUrl;
    private String serviceTitle;
    private LocalDateTime reviewCreated;
    private String reviewDateString;
    private OrderStatus orderStatus;
    private int totalPrice;
    private String reviewContent;
    private double reviewGrade;

}
