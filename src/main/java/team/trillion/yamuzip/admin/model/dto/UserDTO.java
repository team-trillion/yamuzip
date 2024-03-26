package team.trillion.yamuzip.admin.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class UserDTO {

    private int userCode;
    private String userName;
    private String userId;
    private String phone;
    //
    //
    private Date registDatetime;
    //
}
