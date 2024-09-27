package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Shipping implements Serializable {
	private static final long serialVersionUID = 112131212L;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("name")
    private String name;
	
    @JsonProperty("phone")
    private String phone;
	
    @JsonProperty(value = "cycle")
    private String cycle;

    @JsonProperty("address")
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
