package com.user.center.enums;

public enum UserStatusEnum {

    NORMAL(1,"正常"),
    DELETE(2,"删除");

    private int code;

    private String value;

    private UserStatusEnum(int code, String value){
        this.code = code;
        this.value =value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
