package team.trillion.yamuzip.common.enums;

import lombok.Getter;

@Getter
public enum UserAuth {
    GENERAL("회원"),
    DOBBY("도비");

    private String userAuth;
    UserAuth(String userAuth) {
        this.userAuth = userAuth;
    }
}
