package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaymentRequestPaymentData implements Serializable {
	private static final long serialVersionUID = 8891781782121L;
	
	@JsonProperty("payment_currency_code")
    private String paymentCurrencyCode;
	
	@JsonProperty("payment_amount")
    private BigDecimal paymentAmount;
	
	@JsonProperty("exchange_token")
    private String exchangeToken;
	
	@JsonProperty("exchange_rate")
    private BigDecimal exchangeRate;
	
	@JsonProperty("settlement_currency_code")
    private String settlementCurrencyCode;
	
	@JsonProperty("installments")
    private Integer installments;
	
	@JsonProperty("card")
    private CardInfo card;

    public String getPaymentCurrencyCode() {
        return paymentCurrencyCode;
    }

    public void setPaymentCurrencyCode(String paymentCurrencyCode) {
        this.paymentCurrencyCode = paymentCurrencyCode;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getExchangeToken() {
        return exchangeToken;
    }

    public void setExchangeToken(String exchangeToken) {
        this.exchangeToken = exchangeToken;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getSettlementCurrencyCode() {
        return settlementCurrencyCode;
    }

    public void setSettlementCurrencyCode(String settlementCurrencyCode) {
        this.settlementCurrencyCode = settlementCurrencyCode;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public CardInfo getCard() {
        return card;
    }

    public void setCard(CardInfo card) {
        this.card = card;
    }
}
