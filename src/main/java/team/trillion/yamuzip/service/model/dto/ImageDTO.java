package team.trillion.yamuzip.service.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ImageDTO {
    private String imgUrl;
    private String imgOriginName;
    private String imgName;
    private long imgCode;
    private char section;
    private long serviceCode;



    public ImageDTO(String imgOriginName, String imgName, String imgUrl, char section) {
        this.imgOriginName = imgOriginName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.section = section;
    }


}
