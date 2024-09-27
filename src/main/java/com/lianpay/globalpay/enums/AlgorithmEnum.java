package com.lianpay.globalpay.enums;

public enum AlgorithmEnum {
    HMAC("SHA256withHMAC"),
    RSA("SHA1withRSA");

    private final String signAlg;

    AlgorithmEnum(String signAlg) {
        this.signAlg = signAlg;
    }

    public String getSignAlg() {
        return signAlg;
    }

    public static AlgorithmEnum getByName(String algorithm) {
        for (AlgorithmEnum algorithmEnum : AlgorithmEnum.values()) {
            if (algorithmEnum.name().equals(algorithm)) {
                return algorithmEnum;
            }
        }
        return AlgorithmEnum.RSA;
    }
}
