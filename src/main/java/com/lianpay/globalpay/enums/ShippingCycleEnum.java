package com.lianpay.globalpay.enums;

public enum ShippingCycleEnum {
    h12("12h"),
    h24("24h"),
    h48("48h"),
    h72("72h"),
    other("other");

    private final String code;

    ShippingCycleEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
