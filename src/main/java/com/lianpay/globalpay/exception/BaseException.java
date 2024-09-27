package com.lianpay.globalpay.exception;

public class BaseException extends Exception {
    private static final long serialVersionUID = 1213131331111111L;
    private String code;
    private String msg;

    public BaseException() {
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseException(String message, Throwable cause, String code, String msg) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return this.msg + "(" + this.code + ")";
    }
}
