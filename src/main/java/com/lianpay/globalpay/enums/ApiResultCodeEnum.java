package com.lianpay.globalpay.enums;

import java.text.MessageFormat;

public enum ApiResultCodeEnum {

    /**
     * 请求处理成功
     */
    SUCCESS("200", "Success"),

    /**
     * {0} is parameter name
     */
    INVALID_PARAMETER("400", "[{0}] is empty or incorrect"),


    /**
     * 代付account为空
     */
    INVALID_PAYEE_ACCOUNT("400", "Payee account invalid"),

    /**
     * 签名不合法
     */
    INVALID_SIGNATURE("401", "Invalid signature"),

    /**
     * 非法商户ID
     */
    INVALID_MERCHANT("401", "Invalid merchant id"),

    /**
     * 非法二级商户号
     */
    INVALID_SECONDARY_MERCHANT("401", "Invalid secondary merchant id"),

    /**
     * 请求来源IP未被授权访问
     */
    IP_NOT_AUTHORIZED("401", "Merchant IP is not authorized"),

    /**
     * 商户未激活
     */
    INACTIVE_MERCHANT("401", "The Merchant is inactive, please contact our support"),

    /**
     * REFERER无效
     */
    REFERER_NOT_AUTHORIZED("401", "Merchant Referer is not authorized"),

    /**
     * 代付 超过限额
     */
    TRANSACTION_AMOUNT_EXCEEDED("403","The transaction amount requested is higher than the prescribed maximum for the chosen payee bank"),
    
    /**
     * 客户受限
     */
    CUSTOMER_HAS_RESTRICTIONS("403", "This transaction could not be completed at this moment, please try again later or try a different payment method."),

    /**
     * 超过年度限额
     */
    ANNUAL_LIMIT_EXCEEDED("403", "The Customer has exceeded the annual limit. For him to continue shopping, send proof of income to request limit increase"),

    /**
     * {0} is payment currency
     * {1} is max payment amount
     */
    BOLETO_LIMIT_EXCEEDED("403", "The Customer can only order up to <{0}> <{1}> per transaction or per month in " +
            "payments via boleto"),

    /**
     * {0} is settlement currency
     * {1} is max settlement amount
     */
    FX_TRANSACTION_LIMIT_EXCEEDED("403", "The Customer can only order up to <{0}> <{1}> per transaction"),

    /**
     * HTTP 404
     */
    HTTP_NOT_FOUND("404", "HTTP 404 Not Found"),

    /**
     * {0} is object name
     */
    OBJECT_NOT_FOUND("404", "<{0}> not found"),

    /**
     * 代付-不支持的账户
     */
    NOT_SUPPORT("406", "Payee account not support"),
    
    /////////////////////////以上为没有创单前的错误//////////////////////////////

    /**
     * {0} is object name
     * {1} is id
     */
    EXISTING_OBJECT("409", "<{0}> <{1}> already exists"),

    /**
     * {0} is order id
     */
    PAYMENT_COMPLETED("409", "Order <{0}> is paid"),

    /**
     * {0} is order id
     */
    PAYMENT_PROCESSING("409", "Order <{0}> is processing"),

    /**
     * {0} is order id
     */
    PAYMENT_CLOSED("409", "Order <{0}> is closed"),

    /**
     * 余额不足
     */
    CARD_BALANCE_INSUFFICIENT("409", "Payment failed"),

    /**
     * 退款状态异常
     */
    REFUND_STATUS_ERROR("409", "Refund status error"),
    /**
     * 物流单已确认处理
     */
    SHIPMENT_CONFIRMED("409", "Shipment is confirmed"),
    
    /**
     * 订阅支付重复
     */
    SUBSCRIPTION_DUPLICATE_PAYMENT("409", "Subscription duplicate payment"),
    
    /**
     * 订阅状态
     */
    SUBSCRIPTION_STATUS_INVALID("409", "Subscription status invalid"),

    /**
     * 订阅金额超限
     */
    SUBSCRIPTION_AMOUNT_EXCEEDED("409", "Subscription amount exceeded"),
    
    /**
     * 不在订阅支付周期内
     */
    SUBSCRIPTION_NOT_IN_CYClE("409", "Not in subscription cycle"),
    
    /**
     * 变更失败
     */
    CARD_UPDATE_FAILED("409", "Card update failed"),
    
    /**
     * 退款超额
     */
    REFUND_AMOUNT_EXCEEDED("422", "The refund amount can not be greater than the amount of the  order previously paid"),

    /**
     * 订单不能退款
     */
    NON_REFUNDABLE_ORDER("422", "The Current order status does not allow a refund"),
    
    /**
     * 上一个退款单正在处理中
     */
    EXIST_PROCESSING_REFUND("422", "The previous refund of this order is still being processed."),

    /**
     * 上一个争议单正在处理中
     */
    EXIST_PROCESSING_DISPUTE("422", "The previous dispute of this order is still being processed."),

    /**
     * 已申请退款
     */
    REFUND_ALREADY_REQUESTED("422", "The refund of this order has already been requested."),

    /**
     * 商户余额不足
     */
    INSUFFICIENT_BALANCE("422", "Merchant does not have enough balance for this operation"),

    /**
     *
     */
    NON_REISSUABLE_PAYMENT("422", "Can not reissue order payment due to inconsistent order information"),

    /**
     * 订单处理错误
     */
    ERROR_DURING_ORDER_PROCESSING("422", "An error occurred during order processing, please try again later"),

    /**
     * 代付相关
     */
    /**
     * 请求参数无效
     */
    REQUEST_ARGUMENT_INVALID("422", "request atument invalid"),

    /**
     * 代付单已经存在
     */
    DISBURSEMENT_MERCHANT_ORDER_NO_EXIST("422", "disbursement merchant order no already exist"),


    /**
     * 系统繁忙
     */
    SYSTEM_BUSY("422", "System busy"),

    /**
     * 系统错误
     */
    INTERNAL_SERVER_ERROR("422", "System error"),

    /**
     * 不支持的HTTP request method
     */
    METHOD_NOT_ALLOWED("405", "Method Not Allowed"),

    /**
     * Request is not acceptable
     */
    NOT_ACCEPTABLE("406", "Not Acceptable"),

    ;

    /**
     * http状态码， 响应结果的http状态码
     */
    private final String httpCode;

    /**
     * message, 响应结果描述
     */
    private final String msg;

    ApiResultCodeEnum(String httpCode, String msg) {
        this.httpCode = httpCode;
        this.msg = msg;
    }

    public String getHttpCode() {
        return httpCode;
    }

    public String getMsg() {
        return msg;
    }

    public String getMsg(String[] parameterNames) {
        if (this.msg == null) {
            return null;
        }
        return MessageFormat.format(this.msg, parameterNames);
    }
}
