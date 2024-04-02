package team.trillion.yamuzip.common.enums;

import lombok.Getter;

@Getter
public enum PayType {
    toss("토스페이먼츠"),
    card("카드결제");

    private String payType;
    PayType(String payType) {
        this.payType = payType;
    }
}
