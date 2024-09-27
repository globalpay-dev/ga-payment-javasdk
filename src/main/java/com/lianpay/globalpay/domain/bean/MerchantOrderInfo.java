package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class MerchantOrderInfo implements Serializable {
	private static final long serialVersionUID = 8891781782121L;
	
	@JsonProperty("merchant_order_id")
    private String merchantOrderId;
	
	@JsonProperty("merchant_user_no")
    private String merchantUserNo;
	
	@JsonProperty("merchant_order_time")
    private String merchantOrderTime;
	
	@JsonProperty("order_description")
    private String orderDescription;
	
	@JsonProperty("due_date")
    private String dueDate;
    
    @JsonProperty(value = "mcc")
    private String mcc;
	
	@JsonProperty("order_amount")
    private BigDecimal orderAmount;
	
	@JsonProperty("order_currency_code")
    private String orderCurrencyCode;
	
	@JsonProperty("tax")
    private BigDecimal tax;
	
	@JsonProperty("products")
    private List<Product> products;
	
	@JsonProperty("shipping")
    private Shipping shipping;

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getMerchantUserNo() {
        return merchantUserNo;
    }

    public void setMerchantUserNo(String merchantUserNo) {
        this.merchantUserNo = merchantUserNo;
    }

    public String getMerchantOrderTime() {
        return merchantOrderTime;
    }

    public void setMerchantOrderTime(String merchantOrderTime) {
        this.merchantOrderTime = merchantOrderTime;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderCurrencyCode() {
        return orderCurrencyCode;
    }

    public void setOrderCurrencyCode(String orderCurrencyCode) {
        this.orderCurrencyCode = orderCurrencyCode;
    }
    
    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
}
