package com.lianpay.globalpay.exception;

public class SignException extends BaseException {
    private static final long serialVersionUID = 1213131331111111L;

    public SignException() {
    }

    public SignException(String message, Throwable cause) {
        super(message, cause);
    }

    public SignException(String code, String msg) {
        super(code, msg);
    }

    public SignException(String message, Throwable cause, String code, String msg) {
        super(message, cause, code, msg);
    }
}
