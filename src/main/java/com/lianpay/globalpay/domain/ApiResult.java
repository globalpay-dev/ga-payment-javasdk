package com.lianpay.globalpay.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianpay.globalpay.utils.JacksonUtils;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T extends Serializable> implements Serializable {
	private static final long serialVersionUID = 112131212L;
    /**
     * 业务状态码
     */
    @JsonProperty(value = "return_code")
    private String returnCode;

    /**
     * 消息
     */
    @JsonProperty(value = "return_message")
    private String returnMessage;
    
    /**
     * 拒绝编码
     *
     */
    @JsonProperty(value = "decline_code")
    private String declineCode;

    /**
     * 调用链ID, 用于定位问题
     */
    @JsonProperty(value = "trace_id")
    private String traceId;

    /**
     * 响应的数据
     */
    @JsonProperty(value = "order")
    private T order;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getDeclineCode() {
        return declineCode;
    }

    public void setDeclineCode(String declineCode) {
        this.declineCode = declineCode;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public T getOrder() {
        return order;
    }

    public void setOrder(T order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJsonString(this);
    }
}
