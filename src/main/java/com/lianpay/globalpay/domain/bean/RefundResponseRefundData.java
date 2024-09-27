package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class RefundResponseRefundData implements Serializable {
    private static final long serialVersionUID = 8800338642001610211L;
    /**
     * 退款计价币种
     */
    @JsonProperty(value = "refund_currency_code")
    private String refundCurrencyCode;

    /**
     * 退款金额，累计退款不可超出原支付金额（按照该订单的报价币种来统计）
     */
    @JsonProperty(value = "refund_amount")
    private String refundAmount;

    /**
     * 商户出账币种
     */
    @JsonProperty(value = "settlement_currency_code")
    private String settlementCurrencyCode;

    /**
     * 商户出账金额
     */
    @JsonProperty(value = "settlement_amount")
    private String settlementAmount;

    /**
     * 实际退款币种
     */
    @JsonProperty(value = "actual_refund_currency_code")
    private String  actualRefundCurrencyCode;

    /**
     * 实际退款金额
     */
    @JsonProperty(value = "actual_refund_amount")
    private String actualRefundAmount;

    /**
     * 退款状态
     */
    @JsonProperty(value = "refund_status")
    private String refundStatus;

    /**
     * 退款汇率
     */
    @JsonProperty(value = "exchange_rate")
    private String exchangeRate;

    /**
     * 退款完成时间yyyyMMddHHmmss
     */
    @JsonProperty(value = "refund_time")
    private String refundTime;

    /**
     * 退款原因描述
     */
    @JsonProperty(value = "reason")
    private String reason;

    /**
     * 退款确认账务日期： yyyyMMdd
     */
    @JsonProperty(value = "account_date")
    private String accountDate;

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

    public String getSettlementCurrencyCode() {
        return settlementCurrencyCode;
    }

    public void setSettlementCurrencyCode(String settlementCurrencyCode) {
        this.settlementCurrencyCode = settlementCurrencyCode;
    }

    public String getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(String settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public String getActualRefundCurrencyCode() {
        return actualRefundCurrencyCode;
    }

    public void setActualRefundCurrencyCode(String actualRefundCurrencyCode) {
        this.actualRefundCurrencyCode = actualRefundCurrencyCode;
    }

    public String getActualRefundAmount() {
        return actualRefundAmount;
    }

    public void setActualRefundAmount(String actualRefundAmount) {
        this.actualRefundAmount = actualRefundAmount;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(String refundTime) {
        this.refundTime = refundTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }
}
