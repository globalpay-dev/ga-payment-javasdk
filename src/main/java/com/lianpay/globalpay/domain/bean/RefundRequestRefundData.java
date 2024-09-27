package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class RefundRequestRefundData implements Serializable {
    private static final long serialVersionUID = -147028691857933938L;
    /**
     * 退款币种：USD、BRL
     */
    @JsonProperty(value = "refund_currency_code")
    private String refundCurrencyCode;

    /**
     * 退款金额，累计退款不可超出原支付金额（按照该订单的报价币种来统计）
     */
    @JsonProperty(value = "refund_amount")
    private String refundAmount;

    /**
     * 银行卡信息详见4.5
     */
    @JsonProperty(value = "card")
    private BankCard card;

    /**
     * 退款原因描述
     */
    @JsonProperty(value = "reason")
    private String reason;

    public String getRefundCurrencyCode() {
        return refundCurrencyCode;
    }

    public void setRefundCurrencyCode(String refundCurrencyCode) {
        this.refundCurrencyCode = refundCurrencyCode;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BankCard getCard() {
        return card;
    }

    public void setCard(BankCard card) {
        this.card = card;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
