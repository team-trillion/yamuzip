package team.trillion.yamuzip.service.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ImageDTO {

    private long imgCode;
    private String imgUrl;
    private String imgOriginName;
    private String imgName;
    private String section;
    private long noticeCode;
    private ServiceDTO serviceCode;
    private ReviewDTO reviewCode;
    private CsDTO csCode;
}
