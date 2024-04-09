package team.trillion.yamuzip.common.enums;

import lombok.Getter;

@Getter
public enum ServiceStatus {
    A("활성화"),
    U("비활성화"),
    R("삭제"),
    H("숨김");

    private String serviceStatus;
    ServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
}
