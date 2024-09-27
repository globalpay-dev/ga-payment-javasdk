package com.lianpay.globalpay.exception;

public class HttpClientException extends BaseException {
    private static final long serialVersionUID = 734058011024314180L;


    public HttpClientException() {
    }

    public HttpClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpClientException(String code, String msg) {
        super(code, msg);
    }

    public HttpClientException(String message, Throwable cause, String code, String msg) {
        super(message, cause, code, msg);
    }
}
