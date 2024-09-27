package com.lianpay.globalpay.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianpay.globalpay.domain.bean.RefundRequestRefundData;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RefundRequest extends BaseRequest {
    private static final long serialVersionUID = 1366862764142728162L;
    /**
     * 商户退款时间:
     * yyyyMMddHHmmss
     */
    @JsonProperty(value = "merchant_refund_time")
    private String merchantRefundTime;

    /**
     * 原支付单号
     */
    @JsonProperty(value = "original_transaction_id")
    private String originalTransactionId;

    /**
     * 退款数据
     */
    @JsonProperty(value = "refund_data")
    private RefundRequestRefundData refundData;

    public String getMerchantRefundTime() {
        return merchantRefundTime;
    }

    public void setMerchantRefundTime(String merchantRefundTime) {
        this.merchantRefundTime = merchantRefundTime;
    }

    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    public void setOriginalTransactionId(String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
    }

    public RefundRequestRefundData getRefundData() {
        return refundData;
    }

    public void setRefundData(RefundRequestRefundData refundData) {
        this.refundData = refundData;
    }
}