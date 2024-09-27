package com.lianpay.globalpay.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BaseRequest implements Serializable {
    private static final long serialVersionUID = -4680154952194789807L;
    @JsonProperty("merchant_transaction_id")
    private String merchantTransactionId;

    @JsonProperty("merchant_id")
    private String merchantId;

    @JsonProperty("sub_merchant_id")
    private String subMerchantId;

    @JsonProperty("notification_url")
    private String notificationUrl;

    @JsonProperty("redirect_url")
    private String redirectUrl;

    @JsonProperty("cancel_url")
    private String cancelUrl;

    @JsonProperty("country")
    private String country;

    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

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

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
