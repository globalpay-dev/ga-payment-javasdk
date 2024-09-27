package com.lianpay.globalpay.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CancelPayResponse implements Serializable {
    private static final long serialVersionUID = 6753219307363976326L;
    /**
     * 商户号
     */
//    @JsonProperty("merchant_id")
    private String merchantId;

    /**
     * 商户支付单号
     */
//    @JsonProperty("merchant_transaction_id")
    private String merchantTransactionId;

    /**
     * 取消标识 true取消，false取消失败
     */
//    @JsonProperty("allow_cancel")
    private Boolean allowCancel;
    /**
     * 提示信息，取消失败情况下有值
     */
//    @JsonProperty("message")
    private String message;

    /**
     * 执行取消的时间戳
     */
//    @JsonProperty("cancel_time")
    private Long cancelTime;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

    public Boolean getAllowCancel() {
        return allowCancel;
    }

    public void setAllowCancel(Boolean allowCancel) {
        this.allowCancel = allowCancel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Long cancelTime) {
        this.cancelTime = cancelTime;
    }
}
