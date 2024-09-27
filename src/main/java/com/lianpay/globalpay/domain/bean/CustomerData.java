package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CustomerData implements Serializable {

    @JsonProperty("customer_name")
    private String customerName;


    @JsonProperty("customer_email")
    private String customerEmail;

    @JsonProperty("customer_phone_number")
    private String customerPhoneNumber;

//    @JsonProperty("customer_country")
//    private String customerCountry;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

//    public String getCustomerCountry() {
//        return customerCountry;
//    }
//
//    public void setCustomerCountry(String customerCountry) {
//        this.customerCountry = customerCountry;
//    }
}
