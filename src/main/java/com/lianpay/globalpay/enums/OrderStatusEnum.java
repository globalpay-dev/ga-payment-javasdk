package com.lianpay.globalpay.enums;

public enum OrderStatusEnum {
	IN(0, "Payment Initialize"),
	ER(1, "Error"),
    WP(2, "Waiting for Payment"),
    PP(3, "Payment Processing"),
    PC(4, "Payment Cancel"),
    PF(5, "Payment Failed"),
    PS(6, "Payment Success"),
    RP(7, "Refund Processing"),
    PR(8, "Pational Refund"),
    RS(9, "Refund Success"),
    CB(10, "Charge Back");
    

    private final String desc;
    private final int lvl;

    OrderStatusEnum(int lvl, String desc) {

        this.desc = desc;
        this.lvl = lvl;
    }

    public String getDesc() {

        return desc;
    }

    public int getLvl() {

        return lvl;
    }

}
