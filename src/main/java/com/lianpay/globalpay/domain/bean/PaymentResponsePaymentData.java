package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PaymentResponsePaymentData implements Serializable {
	private static final long serialVersionUID = 8891781782121L;
	
	@JsonProperty("payment_currency_code")
    private String paymentCurrencyCode;
	
	@JsonProperty("payment_amount")
    private String paymentAmount;
	
	@JsonProperty("exchange_rate")
    private String exchangeRate;
	
	@JsonProperty("payment_time")
    private String paymentTime;
	
	@JsonProperty("payment_status")
    private String paymentStatus;
	
	@JsonProperty("settlement_currency_code")
    private String settlementCurrencyCode;
	
	@JsonProperty("settlement_amount")
    private String settlementAmount;
	
	@JsonProperty("installments")
    private String installments;
	
	@JsonProperty("account_date")
    private String accountDate;

    @JsonProperty("card_no")
    private String cardNo;

    @JsonProperty("card_brand")
    private String cardBrand;

    @JsonProperty("card_country")
    private String cardCountry;


    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getCardCountry() {
        return cardCountry;
    }

    public void setCardCountry(String cardCountry) {
        this.cardCountry = cardCountry;
    }

    public String getPaymentCurrencyCode() {
        return paymentCurrencyCode;
    }

    public void setPaymentCurrencyCode(String paymentCurrencyCode) {
        this.paymentCurrencyCode = paymentCurrencyCode;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    
    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getSettlementCurrencyCode() {
        return settlementCurrencyCode;
    }

    public void setSettlementCurrencyCode(String settlementCurrencyCode) {
        this.settlementCurrencyCode = settlementCurrencyCode;
    }

    public String getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(String settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public String getInstallments() {
        return installments;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public String getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }
}
