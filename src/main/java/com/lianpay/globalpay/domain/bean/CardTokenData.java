package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CardTokenData implements Serializable {



    @JsonProperty("lianlian_card_token_id")
    private String lianlianCardTokenId;


    @JsonProperty("holder_name")
    private String holderName;

    @JsonProperty("card_no")
    private String cardNo;

    @JsonProperty("card_expiration_year")
    private String cardExpirationYear;

    @JsonProperty("card_expiration_month")
    private String cardExpirationMonth;

    @JsonProperty("lianlian_card_token_status")
    private String lianlianCardTokenStatus;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("card_token_type")
    private String cardTokenType;

    public String getLianlianCardTokenId() {
        return lianlianCardTokenId;
    }

    public void setLianlianCardTokenId(String lianlianCardTokenId) {
        this.lianlianCardTokenId = lianlianCardTokenId;
    }

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

    public String getLianlianCardTokenStatus() {
        return lianlianCardTokenStatus;
    }

    public void setLianlianCardTokenStatus(String lianlianCardTokenStatus) {
        this.lianlianCardTokenStatus = lianlianCardTokenStatus;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCardTokenType() {
        return cardTokenType;
    }

    public void setCardTokenType(String cardTokenType) {
        this.cardTokenType = cardTokenType;
    }
}
