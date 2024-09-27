package com.lianpay.globalpay.enums;

public enum CardTypeEnum {
    D("DEBIT"),
    C("CREDIT");

    private final String description;

    CardTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static CardTypeEnum getCardTypeEnumByName(String name){
        if (null == name){
            return null;
        }
        for(CardTypeEnum cardTypeEnum: CardTypeEnum.values()){
            if (cardTypeEnum.name().equals(name)){
                return cardTypeEnum;
            }
        }
        return null;
    }
}
