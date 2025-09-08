package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 112131212L;
	
    @JsonProperty("line1")
    private String line1;
	
	@JsonProperty("line2")
    private String line2;

	@JsonProperty("city")
    private String city;
	
	@JsonProperty("state")
    private String state;
	
	@JsonProperty("country")
    private String country;
	
	@JsonProperty("postal_code")
    private String postalCode;
    
    @JsonProperty("house_number")
	private String houseNumber;


    @JsonProperty("district")
    private String district;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
