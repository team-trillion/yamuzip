package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CalcDetailDTO {

    // 서비스
    private String serviceTitle;
    private String serviceExplain;
    private String thumbnailUrl;
    private Date reserveDatetime;

    // 정산
    private int accCode;
    private String accNumber;
    private String accBank;
    private String accName;
    private String userName;
    private int orderCode;
    private int payPrice;
    private int chargePrice;
    private int calResult;
    private int calStatus;

}
