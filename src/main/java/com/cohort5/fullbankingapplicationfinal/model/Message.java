package com.cohort5.fullbankingapplicationfinal.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Message {

    private int code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public Message(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
