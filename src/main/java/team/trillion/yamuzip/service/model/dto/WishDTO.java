package team.trillion.yamuzip.service.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class WishDTO {
    private long wishCode;
    private long userCode;
    private long serviceCode;
    private int wishCount;

    public WishDTO() {
    }

    public WishDTO(long wishCode, long userCode, long serviceCode) {
        this.wishCode = wishCode;
        this.userCode = userCode;
        this.serviceCode = serviceCode;
    }
}
