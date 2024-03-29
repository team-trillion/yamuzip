package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class DobbyDTO {

    private int dobCode;
    private String userId;
    private String dobNickname;
    private String userName;
    private String phone;
    private int dobbyServiceCount;
    private Date registDatetime;
    private Date orderDatetime;
    private ServiceDTO dobService;
}
