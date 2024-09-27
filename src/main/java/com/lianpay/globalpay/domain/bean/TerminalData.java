package com.lianpay.globalpay.domain.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class TerminalData implements Serializable {

    private static final long serialVersionUID = 1536034131926616466L;
    /**
     * 用户下单IP
     */
    @JsonProperty(value = "user_order_ip")
    private String userOrderIp;

    /**
     * 业务来源
     */
    @JsonProperty(value = "user_client_mode")
    private String userClientMode;

    /**
     * 用户客户端App类型
     */
    @JsonProperty(value = "user_client_app_type")
    private String userClientAppType;


    /**
     * android 需要 imei
     */
    @JsonProperty(value = "user_client_android_imei")
    private String userClientAndroidImei;

    /**
     * android 需要 sim Id
     */
    @JsonProperty(value = "user_client_android_sim_id")
    private String userClientAndroidSimId;

    /**
     * ios  需要uuid(imei+imsi)
     */
    @JsonProperty(value = "user_client_ios_machine_id")
    private String userClientIosMachineId;


    @JsonProperty(value = "user_client_browser_accept_header")
    private String userClientBrowserAcceptHeader;


    @JsonProperty(value = "user_client_browser_color_depth")
    private String userClientBrowserColorDepth;


    @JsonProperty(value = "user_client_browser_java_enabled")
    private Boolean userClientBrowserJavaEnabled;

    @JsonProperty(value = "user_client_browser_js_enabled")
    private Boolean userClientBrowserJsEnabled;

    @JsonProperty(value = "user_client_browser_language")
    private String userClientBrowserLanguage;

    @JsonProperty(value = "user_client_browser_screen_height")
    private String userClientBrowserScreenHeight;

    @JsonProperty(value = "user_client_browser_screen_width")
    private String userClientBrowserScreenWidth;

    @JsonProperty(value = "user_client_browser_time_zone_offset")
    private String userClientBrowserTimeZoneOffset;

    @JsonProperty(value = "user_client_browser_user_agent")
    private String userClientBrowserUserAgent;

    public String getUserOrderIp() {
        return userOrderIp;
    }

    public void setUserOrderIp(String userOrderIp) {
        this.userOrderIp = userOrderIp;
    }

    public String getUserClientMode() {
        return userClientMode;
    }

    public void setUserClientMode(String userClientMode) {
        this.userClientMode = userClientMode;
    }

    public String getUserClientAppType() {
        return userClientAppType;
    }

    public void setUserClientAppType(String userClientAppType) {
        this.userClientAppType = userClientAppType;
    }

    public String getUserClientAndroidImei() {
        return userClientAndroidImei;
    }

    public void setUserClientAndroidImei(String userClientAndroidImei) {
        this.userClientAndroidImei = userClientAndroidImei;
    }

    public String getUserClientAndroidSimId() {
        return userClientAndroidSimId;
    }

    public void setUserClientAndroidSimId(String userClientAndroidSimId) {
        this.userClientAndroidSimId = userClientAndroidSimId;
    }

    public String getUserClientIosMachineId() {
        return userClientIosMachineId;
    }

    public void setUserClientIosMachineId(String userClientIosMachineId) {
        this.userClientIosMachineId = userClientIosMachineId;
    }

    public String getUserClientBrowserAcceptHeader() {
        return userClientBrowserAcceptHeader;
    }

    public void setUserClientBrowserAcceptHeader(String userClientBrowserAcceptHeader) {
        this.userClientBrowserAcceptHeader = userClientBrowserAcceptHeader;
    }

    public String getUserClientBrowserColorDepth() {
        return userClientBrowserColorDepth;
    }

    public void setUserClientBrowserColorDepth(String userClientBrowserColorDepth) {
        this.userClientBrowserColorDepth = userClientBrowserColorDepth;
    }

    public Boolean getUserClientBrowserJavaEnabled() {
        return userClientBrowserJavaEnabled;
    }

    public void setUserClientBrowserJavaEnabled(Boolean userClientBrowserJavaEnabled) {
        this.userClientBrowserJavaEnabled = userClientBrowserJavaEnabled;
    }

    public Boolean getUserClientBrowserJsEnabled() {
        return userClientBrowserJsEnabled;
    }

    public void setUserClientBrowserJsEnabled(Boolean userClientBrowserJsEnabled) {
        this.userClientBrowserJsEnabled = userClientBrowserJsEnabled;
    }

    public String getUserClientBrowserLanguage() {
        return userClientBrowserLanguage;
    }

    public void setUserClientBrowserLanguage(String userClientBrowserLanguage) {
        this.userClientBrowserLanguage = userClientBrowserLanguage;
    }

    public String getUserClientBrowserScreenHeight() {
        return userClientBrowserScreenHeight;
    }

    public void setUserClientBrowserScreenHeight(String userClientBrowserScreenHeight) {
        this.userClientBrowserScreenHeight = userClientBrowserScreenHeight;
    }

    public String getUserClientBrowserScreenWidth() {
        return userClientBrowserScreenWidth;
    }

    public void setUserClientBrowserScreenWidth(String userClientBrowserScreenWidth) {
        this.userClientBrowserScreenWidth = userClientBrowserScreenWidth;
    }

    public String getUserClientBrowserTimeZoneOffset() {
        return userClientBrowserTimeZoneOffset;
    }

    public void setUserClientBrowserTimeZoneOffset(String userClientBrowserTimeZoneOffset) {
        this.userClientBrowserTimeZoneOffset = userClientBrowserTimeZoneOffset;
    }

    public String getUserClientBrowserUserAgent() {
        return userClientBrowserUserAgent;
    }

    public void setUserClientBrowserUserAgent(String userClientBrowserUserAgent) {
        this.userClientBrowserUserAgent = userClientBrowserUserAgent;
    }
}