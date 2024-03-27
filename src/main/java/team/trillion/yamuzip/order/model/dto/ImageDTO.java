package team.trillion.yamuzip.order.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ImageDTO {

    private int imgCode;
    private String imgUrl;
    private String imgOriginName;
    private String imgName;
    private char section;
    private int noticeCode;
    private int serviceCode;
    private int reviewCode;
    private int csCode;

}
