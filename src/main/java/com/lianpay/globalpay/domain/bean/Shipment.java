package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Shipment implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 承运商code,非标准，后续会映射
     */
    @JsonProperty(value = "carrier_code")
    private String carrierCode;

    /**
     * 物流单号
     */
    @JsonProperty(value = "tracking_no")
    private String trackingNo;

    /**
     * country
     */
    @JsonProperty(value = "country")
    private String country;

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
  
