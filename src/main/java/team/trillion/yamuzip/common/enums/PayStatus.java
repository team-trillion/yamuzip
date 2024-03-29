package team.trillion.yamuzip.common.enums;

import lombok.Getter;

@Getter
public enum PayStatus {
    P("결제완료"),
    R("환불완료");

    private String payStatus;
    PayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
}
