package com.hanbinjava.iexcel.common.exception;

public class ApplicationException extends RuntimeException {
    int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ApplicationException(String message){
        super(message);
        this.code = 500;
    }

    public ApplicationException(Exception e){
        super(e);
        this.code = 500;
    }

    public ApplicationException(int code, Exception e){
        super(e);
        this.code = code;
    }

    public ApplicationException(int code){
        this.code = code;
    }

}
