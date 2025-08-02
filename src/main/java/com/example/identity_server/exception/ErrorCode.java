package com.example.identity_server.exception;

public enum ErrorCode {

    UNCATEGORYZED_EXISTED(9999, "Uncategorized error"),
    INVALID_KEY(1001, "Invalid message key"),
    USER_EXISTED(1002,  "User existed"),
    USERNAME_INVALID(1003, "Username cần ít nhất 3 kí tự"),
    INVALID_PASSWORD(1004, "Password cần ít nhất 8 kí tự"),
    USER_NOT_EXISTED(1005,  "User not existed"),

    ;

    private int code;
    private String message; 
    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
     
}
