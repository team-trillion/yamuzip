package team.trillion.yamuzip.user.mypage.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class OrderStatusDTO {

    private int orderCode;
    private int serviceCode;
    private int userCode;
    private Date orderDatetime;
    private String orderStatus;
    private Date reserveDatetime;
    private String rejectReason;

}
