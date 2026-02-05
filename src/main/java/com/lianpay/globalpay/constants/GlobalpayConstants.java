package com.lianpay.globalpay.constants;

import java.util.HashMap;
import java.util.Map;

public final class GlobalpayConstants {
    public static final String TEST_HOST = "https://celer-api.LianLianpay-inc.com";
    public static final String PROD_HOST = "https://gpapi.LianLianpay.com";

    public static final String HK_PROD_HOST = "https://gpapi-hk.LianLianpay.com";

    public static final String STRING_ON = "ON";
    public static final String STRING_OFF = "OFF";
    public static final String SIGN_TYPE = "sign-type";
    public static final String SIGNATURE = "signature";
    public static final String TIMESTAMP = "timestamp";
    public static final String TIMEZONE = "timezone";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String TIMESTAMP_FORMAT = "yyyyMMddHHmmss";

    public static final String TDS_CHALLENGE = "challenge";

    public static final Map<String, String> GLOBALPAY_DEFAULT_HEADERS;

    static {
        GLOBALPAY_DEFAULT_HEADERS = new HashMap<String, String>();
        GLOBALPAY_DEFAULT_HEADERS.put(SIGN_TYPE, "");
        GLOBALPAY_DEFAULT_HEADERS.put(SIGNATURE, "");
        GLOBALPAY_DEFAULT_HEADERS.put(TIMESTAMP, "");
        GLOBALPAY_DEFAULT_HEADERS.put(TIMEZONE, "Asia/Hong_Kong");
        GLOBALPAY_DEFAULT_HEADERS.put(CONTENT_TYPE, "application/json");
    }
}
