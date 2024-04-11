package team.trillion.yamuzip.service.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ReviewDTO {
    private long reviewCode;
    private long orderCode;
    private long writerUserCode;
    private float reviewGrade;
    private LocalDateTime reviewCreated;
    private char reviewStatus;
    private LocalDateTime reviewModify;
    private UserDTO user;
    private String reviewContent;
    private OrderDTO order;
}
