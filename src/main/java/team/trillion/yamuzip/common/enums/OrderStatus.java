package team.trillion.yamuzip.common.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    O("주문완료"),
    A("예약승인"),
    R("주문거절"),
    F("서비스완료"),
    C("예약취소");

    private String orderStatus;
    OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
