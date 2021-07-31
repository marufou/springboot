package com.example.enums;

public enum AgeEnum {
    ONE(1,"一岁"),
    TWO(2,"两岁"),
    THREE(3,"三岁");

    private Integer code;
    private String msg;

    private AgeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
