package com.lianpay.globalpay.exception;


public class VerifySignFailException extends BaseException {
    private static final long serialVersionUID = 1213131331111111L;

    public VerifySignFailException() {

    }

    public VerifySignFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerifySignFailException(String code, String msg) {
        super(code, msg);
    }

    public VerifySignFailException(String message, Throwable cause, String code, String msg) {
        super(message, cause, code, msg);
    }
}
