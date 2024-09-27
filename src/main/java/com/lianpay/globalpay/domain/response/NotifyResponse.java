package com.lianpay.globalpay.domain.response;

import java.io.Serializable;

public class NotifyResponse implements Serializable {
    private static final long serialVersionUID = -4647900339248627085L;
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
