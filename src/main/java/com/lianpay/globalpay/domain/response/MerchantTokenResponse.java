package com.lianpay.globalpay.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MerchantTokenResponse implements Serializable {

    @JsonProperty(value = "holder_name")
    private String holderName;

    @JsonProperty(value = "card_no")
    private String cardNo;

    @JsonProperty(value = "card_expiration_year")
    private String cardExpirationYear;

    @JsonProperty(value = "card_expiration_month")
    private String cardExpirationMonth;

    @JsonProperty(value = "lianlian_card_token_id")
    private String lianlianCardTokenId;

    @JsonProperty(value = "sub_merchant_id")
    private String submMerchantId;

    @JsonProperty(value = "card_token_type")
    private String cardTokenType;

    @JsonProperty(value = "merchant_user_no")
    private String merchantUserNo;

    @JsonProperty(value = "lianlian_card_token_status")
    private String lianlianCardTokenStatus;

    @JsonProperty(value = "merchant_id")
    private String merchantId;

    @JsonProperty(value = "brand")
    private String brand;

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardExpirationYear() {
        return cardExpirationYear;
    }

    public void setCardExpirationYear(String cardExpirationYear) {
        this.cardExpirationYear = cardExpirationYear;
    }

    public String getCardExpirationMonth() {
        return cardExpirationMonth;
    }

    public void setCardExpirationMonth(String cardExpirationMonth) {
        this.cardExpirationMonth = cardExpirationMonth;
    }

    public String getLianlianCardTokenId() {
        return lianlianCardTokenId;
    }

    public void setLianlianCardTokenId(String lianlianCardTokenId) {
        this.lianlianCardTokenId = lianlianCardTokenId;
    }

    public String getSubmMerchantId() {
        return submMerchantId;
    }

    public void setSubmMerchantId(String submMerchantId) {
        this.submMerchantId = submMerchantId;
    }

    public String getCardTokenType() {
        return cardTokenType;
    }

    public void setCardTokenType(String cardTokenType) {
        this.cardTokenType = cardTokenType;
    }

    public String getMerchantUserNo() {
        return merchantUserNo;
    }

    public void setMerchantUserNo(String merchantUserNo) {
        this.merchantUserNo = merchantUserNo;
    }

    public String getLianlianCardTokenStatus() {
        return lianlianCardTokenStatus;
    }

    public void setLianlianCardTokenStatus(String lianlianCardTokenStatus) {
        this.lianlianCardTokenStatus = lianlianCardTokenStatus;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
