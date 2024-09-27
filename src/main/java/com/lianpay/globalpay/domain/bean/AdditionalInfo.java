package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AdditionalInfo implements Serializable {
    private static final long serialVersionUID = -7945643254794280827L;

    @JsonProperty("merchant_user_id")
    private String merchantUserId;
    @JsonProperty("merchant_user_email")
    private String merchantUserEmail;
    @JsonProperty("merchant_user_login_name")
    private String merchantUserLoginName;
    @JsonProperty("user_register_ip")
    private String userRegisterIp;
    @JsonProperty("user_register_phone")
    private String userRegisterPhone;
    @JsonProperty("user_register_time")
    private String userRegisterTime;
    @JsonProperty("site_url")
    private String siteUrl;

    public String getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public String getMerchantUserEmail() {
        return merchantUserEmail;
    }

    public void setMerchantUserEmail(String merchantUserEmail) {
        this.merchantUserEmail = merchantUserEmail;
    }

    public String getMerchantUserLoginName() {
        return merchantUserLoginName;
    }

    public void setMerchantUserLoginName(String merchantUserLoginName) {
        this.merchantUserLoginName = merchantUserLoginName;
    }

    public String getUserRegisterIp() {
        return userRegisterIp;
    }

    public void setUserRegisterIp(String userRegisterIp) {
        this.userRegisterIp = userRegisterIp;
    }

    public String getUserRegisterPhone() {
        return userRegisterPhone;
    }

    public void setUserRegisterPhone(String userRegisterPhone) {
        this.userRegisterPhone = userRegisterPhone;
    }

    public String getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(String userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}
