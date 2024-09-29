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
     * The name of the cardholder.
     */
    @JsonProperty(value = "holder_name")
    private String holderName;

    /**
     * The type of identification: CPF, CNPJ, etc.
     */
    @JsonProperty(value = "id_type")
    private String idType;

    /**
     * The identification number.
     */
    @JsonProperty(value = "id_no")
    private String idNo;

    /**
     * The card number.
     */
    @JsonProperty(value = "card_no")
    private String cardNo;

    /**
     * The card type: D=Debit, C=Credit.
     */
    @JsonProperty(value = "card_type")
    private String cardType;

    /**
     * The bank code.
     */
    @JsonProperty(value = "bank_code")
    private String bankCode;

    /**
     * The credit card brand.
     */
    @JsonProperty(value = "card_brand")
    private String cardBrand;

    /**
     * The card expiration year.
     * Starts from 2020 onwards.
     */
    @JsonProperty(value = "card_expiration_year")
    private String cardExpirationYear;

    /**
     * The card expiration month.
     */
    @JsonProperty(value = "card_expiration_month")
    private String cardExpirationMonth;

    /**
     * The card security code (CVV).
     */
    @JsonProperty(value = "cvv")
    private String cvv;

    /**
     * The billing address.
     */
    @JsonProperty(value = "billing_address")
    private Address billingAddress;

    /**
     * The bank name.
     */
    @JsonProperty(value = "bank_name")
    private String bankName;

    /**
     * The reserved verification digit.
     */
    @JsonProperty(value = "verifying_digit")
    private String verifyingDigit;

    /**
     * The branch code.
     */
    @JsonProperty(value = "branch_code")
    private String branchCode;

    /**
     * The email address.
     */
    @JsonProperty(value = "email")
    private String email;

    /**
     * The phone number.
     */
    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    /**
     * The card token.
     */
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
