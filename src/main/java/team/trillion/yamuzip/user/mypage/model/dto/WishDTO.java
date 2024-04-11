package team.trillion.yamuzip.user.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class WishDTO {

    private int wishCode;
    private int userCode;
    private int serviceCode;
    private String dobNickname;
    private String serviceTitle;
    private String serviceContent;
    private String serviceExplain;
    private String servicePrice;
    private String thumbnailUrl;

}
