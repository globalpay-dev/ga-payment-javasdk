package com.lianpay.globalpay.enums;

import java.util.Arrays;
import java.util.List;

public enum CustomerTypeEnum {

    I,
    C;

    public static List<CustomerTypeEnum> toList() {
        return Arrays.asList(values());
    }
}
