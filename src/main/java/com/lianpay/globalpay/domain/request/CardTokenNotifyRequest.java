package com.lianpay.globalpay.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianpay.globalpay.domain.bean.CardTokenData;
import com.lianpay.globalpay.domain.bean.CustomerData;
import com.lianpay.globalpay.domain.bean.PaymentResponsePaymentData;

import java.io.Serializable;

public class CardTokenNotifyRequest implements Serializable {
    private static final long serialVersionUID = -7218429360057490099L;

    @JsonProperty("event")
    private String event;

    @JsonProperty("merchant_id")
    private String merchantId;

    @JsonProperty("sub_merchant_id")
    private String subMerchantId;

    @JsonProperty("merchant_user_no")
    private String merchantUserNo;

    @JsonProperty("card_token_data")
    private CardTokenData cardTokenData;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getSubMerchantId() {
        return subMerchantId;
    }

    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    public String getMerchantUserNo() {
        return merchantUserNo;
    }

    public void setMerchantUserNo(String merchantUserNo) {
        this.merchantUserNo = merchantUserNo;
    }

    public CardTokenData getCardTokenData() {
        return cardTokenData;
    }

    public void setCardTokenData(CardTokenData cardTokenData) {
        this.cardTokenData = cardTokenData;
    }
}
