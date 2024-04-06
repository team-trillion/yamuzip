package team.trillion.yamuzip.service.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ImageDTO {
    private String imgUrl;
    private String imgOriginName;
    private String imgName;
    private Long imgCode;
    private char section;
    private long serviceCode;

    public ImageDTO() {
    }

    public ImageDTO(String imgOriginName, String imgName, String imgUrl, char section) {
        this.imgOriginName = imgOriginName;
        this.imgName = imgName;
        this.imgUrl = imgUrl + imgName;
        this.section = section;
    }


    public ImageDTO(Long imgCode, String imgOriginName, String imgName, String imgUrl, char section) {
        this.imgCode = imgCode;
        this.imgOriginName = imgOriginName;
        this.imgName = imgName;
        this.imgUrl = imgUrl + imgName;
        this.section = section;
    }


}
