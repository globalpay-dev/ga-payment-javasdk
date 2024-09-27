package com.lianpay.globalpay.enums;

public enum PaymentTypeEnum {
    BOL("boleto", "boleto"),

    ICR("inter_credit_card", "International credit card"),

    LCR("local_credit_card", "local credit card"),

    QPT("quick_payment", "China Unionpay"),

    PIX("pix", "pix"),

    WEB("web_pay", "web"),

    WAP("wap_pay", "wap"),

    ALT("applets", "applets");

    private final String paymentMethod;
    private final String description;

    PaymentTypeEnum(String paymentMethod, String description) {
        this.paymentMethod = paymentMethod;
        this.description = description;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentTypeEnum getByName(String name) {
        for (PaymentTypeEnum paymentType : PaymentTypeEnum.values()) {
            if (paymentType.name().equals(name)) {
                return paymentType;
            }
        }
        return null;
    }
}
