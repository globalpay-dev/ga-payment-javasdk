package com.lianpay.globalpay.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianpay.globalpay.domain.bean.PaymentResponsePaymentData;

import java.io.Serializable;

public class PaymentsResponse implements Serializable {
	private static final long serialVersionUID = 8891781782121L;
	@JsonProperty("ll_transaction_id")
    private String llTransactionId;
	@JsonProperty("merchant_transaction_id")
    private String merchantTransactionId;
	@JsonProperty("payment_url")
    private String paymentUrl;

    @JsonProperty("tds_flag")
    private String tdsFlag;
	@JsonProperty("payment_data")
    private PaymentResponsePaymentData paymentData;

    @JsonProperty("ext_info")
    private String extInfo;

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

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

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public PaymentResponsePaymentData getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(PaymentResponsePaymentData paymentData) {
        this.paymentData = paymentData;
    }

}
