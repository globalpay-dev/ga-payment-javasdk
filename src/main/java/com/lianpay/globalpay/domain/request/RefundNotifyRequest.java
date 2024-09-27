package com.lianpay.globalpay.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianpay.globalpay.domain.bean.RefundResponseRefundData;

import java.io.Serializable;

public class RefundNotifyRequest implements Serializable {
    private static final long serialVersionUID = 7691434180522642394L;
    @JsonProperty("ll_transaction_id")
    private String llTransactionId;

    @JsonProperty("merchant_transaction_id")
    private String merchantTransactionId;

    @JsonProperty(value = "original_transaction_id")
    private String originalTransactionId;

    @JsonProperty(value = "refund_data")
    private RefundResponseRefundData refundData;


    public String getLlTransactionId() {
        return llTransactionId;
    }

    public void setLlTransactionId(String llTransactionId) {
        this.llTransactionId = llTransactionId;
    }

    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    public void setOriginalTransactionId(String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
    }

    public RefundResponseRefundData getRefundData() {
        return refundData;
    }

    public void setRefundData(RefundResponseRefundData refundData) {
        this.refundData = refundData;
    }
}
