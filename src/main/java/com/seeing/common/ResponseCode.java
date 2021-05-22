package com.seeing.common;

public enum  ResponseCode {

    /**
     *  成功
     *  失败
     *  需要登录
     *  非法参数
     *  token过期
     */
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"),
    FRESH_TOKEN(100,"FRESH_TOKEN");


    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }

}
