package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankCard implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 持卡人姓名
     */
    @JsonProperty(value = "holder_name")
    private String holderName;

    /**
     * 证件类型：CPF, CNPJ etc
     */
    @JsonProperty(value = "id_type")
    private String idType;

    /**
     * 证件号
     */
    @JsonProperty(value = "id_no")
    private String idNo;

    /**
     * 卡号
     */
    @JsonProperty(value = "card_no")
    private String cardNo;

    /**
     * 卡类型：D=借记，C=贷记
     *
     * @see
     */
    @JsonProperty(value = "card_type")
    private String cardType;

    /**
     * 银行编码
     */
    @JsonProperty(value = "bank_code")
    private String bankCode;

    /**
     * 信用卡卡品牌
     */
    @JsonProperty(value = "card_brand")
    private String cardBrand;

    /**
     * 卡有效期——年份
     * 从2020年往后
     */
    @JsonProperty(value = "card_expiration_year")
    private String cardExpirationYear;

    /**
     * 卡有效期——月份
     */
    @JsonProperty(value = "card_expiration_month")
    private String cardExpirationMonth;

    /**
     * 卡安全码
     */
    @JsonProperty(value = "cvv")
    private String cvv;

    /**
     * 账单地址
     */
    @JsonProperty(value = "billing_address")
    private Address billingAddress;

    @JsonProperty(value = "bank_name")
    private String bankName;

    /**
     * 预留校验码
     */
    @JsonProperty(value = "verifying_digit")
    private String verifyingDigit;

    /**
     * 支行code
     */
    @JsonProperty(value = "branch_code")
    private String branchCode;


    /**
     *
     */
    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    @JsonProperty(value = "card_token")
    private String cardToken;

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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getVerifyingDigit() {
        return verifyingDigit;
    }

    public void setVerifyingDigit(String verifyingDigit) {
        this.verifyingDigit = verifyingDigit;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }
}
