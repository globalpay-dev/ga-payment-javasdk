package com.lianpay.globalpay.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianpay.globalpay.domain.bean.RefundResponseRefundData;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefundResponse implements Serializable {

    private static final long serialVersionUID = 8949141814567627797L;
    /**
     * LianLian Pay退款ID
     */
    @JsonProperty(value = "ll_transaction_id")
    private String llTransactionId;

    /**
     * 商户退款ID
     */
    @JsonProperty(value = "merchant_transaction_id")
    private String merchantTransactionId;

    /**
     * 商户原支付单号
     */
    @JsonProperty(value = "original_transaction_id")
    private String originalTransactionId;

    /**
     * 退款数据
     */
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
