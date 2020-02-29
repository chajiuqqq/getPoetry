package com.chajiu.response;

public class Response<T>{
    private Integer code;
    private T data;
    private String message;

    public Response() {
        message="success";
        code=ResponseCodeType.SUCCESS;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public Response code(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public Response data(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}