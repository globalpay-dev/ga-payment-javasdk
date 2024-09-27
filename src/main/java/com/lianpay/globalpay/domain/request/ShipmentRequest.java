package com.lianpay.globalpay.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianpay.globalpay.domain.bean.Shipment;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ShipmentRequest extends BaseRequest {
    private static final long serialVersionUID = -5758227653224514487L;

    /**
     * 退款ID，需要保证唯一性
     */
    @JsonProperty(value = "merchant_transaction_id")
    private String merchantTransactionId;


    @JsonProperty(value = "shipments")
    private List<Shipment> shipments;

    @Override
    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    @Override
    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }
}