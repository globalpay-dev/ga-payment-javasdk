package com.lianpay.globalpay.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianpay.globalpay.domain.bean.CustomerData;
import com.lianpay.globalpay.domain.bean.PaymentResponsePaymentData;

import java.io.Serializable;

public class PaymentsNotifyRequest implements Serializable {
    private static final long serialVersionUID = -7218429360057492382L;

    @JsonProperty("ll_transaction_id")
    private String llTransactionId;

    @JsonProperty("merchant_transaction_id")
    private String merchantTransactionId;

    @JsonProperty("payment_url")
    private String paymentUrl;

    @JsonProperty("payment_data")
    private PaymentResponsePaymentData paymentData;

    @JsonProperty("customer_data")
    private CustomerData customerData;

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

    public CustomerData getCustomerData() {
        return customerData;
    }
    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }
}
