package com.lianpay.globalpay.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CardTokenRequest implements Serializable {

    private static final long serialVersionUID = -7218429360057492001L;


    @JsonProperty("merchant_id")
    private String merchantId;

    @JsonProperty("sub_merchant_id")
    private String subMerchantId;


    @JsonProperty("merchant_user_no")
    private String merchantUserNo;

    @JsonProperty("lianlian_card_token_id")
    private String lianlianCardTokenId;


    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getSubMerchantId() {
        return subMerchantId;
    }

    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    public String getMerchantUserNo() {
        return merchantUserNo;
    }

    public void setMerchantUserNo(String merchantUserNo) {
        this.merchantUserNo = merchantUserNo;
    }

    public String getLianlianCardTokenId() {
        return lianlianCardTokenId;
    }

    public void setLianlianCardTokenId(String lianlianCardTokenId) {
        this.lianlianCardTokenId = lianlianCardTokenId;
    }
}
