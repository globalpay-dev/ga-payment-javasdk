package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CardInfo implements Serializable {
	private static final long serialVersionUID = 112131212L;
	
	@JsonProperty("holder_name")
    private String holderName;
	
	@JsonProperty("id_type")
    private String idType;
	
	@JsonProperty("id_no")
    private String idNo;
	
	@JsonProperty("card_no")
    private String cardNo;
	
	@JsonProperty("card_type")
    private String cardType;
	
	@JsonProperty("bank_code")
    private String bankCode;
	
	@JsonProperty("card_brand")
    private String cardBrand;
	
	@JsonProperty("card_expiration_year")
    private String cardExpirationYear;
	
	@JsonProperty("card_expiration_month")
    private String cardExpirationMonth;
	
	@JsonProperty("cvv")
    private String cvv;
	
	@JsonProperty("billing_address")
    private Address billingAddress;
    
    @JsonProperty("card_token")
    private String cardToken;

    @JsonProperty("email")
    private String email;

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
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

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
   
    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
