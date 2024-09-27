package com.lianpay.globalpay.enums;

public enum CardBrandEnum {
    VISA("visa"),
    MASTERCARD("mastercard"),
    JCB("jcb"),
    AMEX("amex"),
    DINERSCLUB("dinersclub"),
    DISCOVER("discover"),
    elo("elo"),
    hipercard("hipercard");


    private final String code;

    CardBrandEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

