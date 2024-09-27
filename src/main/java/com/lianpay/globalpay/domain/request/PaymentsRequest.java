package com.lianpay.globalpay.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianpay.globalpay.domain.bean.Customer;
import com.lianpay.globalpay.domain.bean.MerchantOrderInfo;
import com.lianpay.globalpay.domain.bean.PaymentRequestPaymentData;
import com.lianpay.globalpay.domain.bean.TerminalData;

import java.io.Serializable;

public class PaymentsRequest extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 8891781782121L;

	@JsonProperty("payment_method")
    private String paymentMethod;
	@JsonProperty("additional_info")
    private String additionalInfo;
    @JsonProperty("customer")
    private Customer customer;
    @JsonProperty("merchant_order")
    private MerchantOrderInfo merchantOrder;
    @JsonProperty("payment_data")
    private PaymentRequestPaymentData paymentData;
    @JsonProperty(value = "terminal_data")
    private TerminalData terminalData;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MerchantOrderInfo getMerchantOrder() {
        return merchantOrder;
    }

    public void setMerchantOrder(MerchantOrderInfo merchantOrder) {
        this.merchantOrder = merchantOrder;
    }

    public PaymentRequestPaymentData getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(PaymentRequestPaymentData paymentData) {
        this.paymentData = paymentData;
    }

    public TerminalData getTerminalData() {
        return terminalData;
    }

    public void setTerminalData(TerminalData terminalData) {
        this.terminalData = terminalData;
    }


}
