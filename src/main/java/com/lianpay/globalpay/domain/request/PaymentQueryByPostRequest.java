package com.lianpay.globalpay.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 支付查询请求对象（POST方式，支持ARN查询）
 * 对应apollo-api-v3中的PaymentQueryByPostApiRequest
 */
public class PaymentQueryByPostRequest implements Serializable {
    private static final long serialVersionUID = 9999999998888882L;

    /**
     * 商户号
     */
    @JsonProperty("merchant_id")
    private String merchantId;

    /**
     * 商户订单号
     */
    @JsonProperty("merchant_transaction_id")
    private String merchantTransactionId;

    /**
     * ARN（Acquirer Reference Number）渠道参考号
     */
    @JsonProperty("arn")
    private String arn;

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

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        this.arn = arn;
    }
}
