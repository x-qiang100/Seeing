package com.seeing.common;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T>{

    private int status;

    private String msg;

    private T data;


    public ServerResponse() {

    }

    public ServerResponse(int status) {
        this.status = status;
    }

    public ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T>ServerResponse<T> createBySuccess(){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode() );
    }

    public static <T>ServerResponse<T> createBySuccessMsg(String msg){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),msg );
    }

    public static <T>ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode() , data );
    }

    public static <T>ServerResponse<T> createBySuccess(String msg , T data){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode() , msg , data );
    }

    public static <T>ServerResponse<T> createByError(){
        return new ServerResponse<>(ResponseCode.ERROR.getCode() );
    }

    public static <T>ServerResponse<T> createByErrorMsg(String errorMsg){
        return new ServerResponse<>(ResponseCode.ERROR.getCode() , errorMsg);
    }

    public static <T>ServerResponse<T> createByErrorCodeMsg(int code , String errorMsg){
        return new ServerResponse<>(code,errorMsg);
    }

}
