package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {
	private static final long serialVersionUID = 112131212L;

	@JsonProperty("product_id")
    private String productId;

	@JsonProperty("name")
    private String name;

	@JsonProperty("description")
    private String description;

	@JsonProperty("price")
    private BigDecimal price;

	@JsonProperty("quantity")
    private int quantity;

	@JsonProperty("category")
    private String category;

	@JsonProperty("sku")
    private String sku;

    @JsonProperty("url")
    private String url;

    @JsonProperty("shipping_provider")
    private String shippingProvider;
    
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getShippingProvider() {
        return shippingProvider;
    }

    public void setShippingProvider(String shippingProvider) {
        this.shippingProvider = shippingProvider;
    }
}
