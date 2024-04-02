package team.trillion.yamuzip.review.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class ReviewDTO {

    private int reviewCode;
    private int orderCode;
    private int userCode;
    private String userId;
    private Data reviewGrade;
    private  String reviewImg;

    private MultipartFile file;

}
