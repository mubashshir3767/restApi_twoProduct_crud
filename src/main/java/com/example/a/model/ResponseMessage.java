package com.example.a.model;

public enum ResponseMessage {
    SUCCESS("transaction is success",0),
    ERROR_USER_ALREADY_EXIST("error user already exist",-100),
    ERROR_LAPTOP_ALREADY_EXIST("error laptop already exist",-200),
    ERROR_USER_NOT_FOUND("error user not found",-101),
    ERROR_LAPTOP_NOT_FOUND("error laptop not found",-201);


    private String message;
    private int status_code;

    public String getMessage() {
        return message;
    }

    public int getStatus_code() {
        return status_code;
    }

    ResponseMessage(String message, int status_code) {
        this.message = message;
        this.status_code = status_code;
    }
}
