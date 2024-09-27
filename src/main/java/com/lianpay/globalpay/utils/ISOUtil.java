package com.lianpay.globalpay.utils;

import com.lianpay.globalpay.constants.GlobalpayConstants;
import com.lianpay.globalpay.reader.MerchantPropertyReader;
import com.lianpay.globalpay.validator.Validator;

import java.util.Map;

public class ISOUtil {
    public static final String EMPTY_STRING = "";

    public static boolean isNullOrEmpty(String data) {
        return data == null || "".equals(data);
    }

    public static int changeToInt(String data) {
        if (isNullOrEmpty(data)) {
            return 0;
        }
        return Integer.parseInt(data);
    }

    public static String getPaymentsUrl(MerchantPropertyReader merchantPropertyReader) {
        String host = getHost(merchantPropertyReader.openTestModel(),merchantPropertyReader.openHKNetModel());
        return host + "/v3/merchants/" + merchantPropertyReader.getMERCHANT_ID() + "/payments";
    }

    public static String getPaymentsQueryUrl(String merchantTransactionId,
                                             MerchantPropertyReader merchantPropertyReader) {
        String host = getHost(merchantPropertyReader.openTestModel(),merchantPropertyReader.openHKNetModel());
        return host + "/v3/merchants/" + merchantPropertyReader.getMERCHANT_ID() + "/payments/" + merchantTransactionId;
    }

    public static String getRefundsUrl(String originalMerchantTransactionId,
                                       MerchantPropertyReader merchantPropertyReader) {
        String host = getHost(merchantPropertyReader.openTestModel(),merchantPropertyReader.openHKNetModel());
        return host + "/v3/merchants/" + merchantPropertyReader.getMERCHANT_ID() + "/payments/" + originalMerchantTransactionId + "/refunds";
    }

    public static String getRefundsQueryUrl(String merchantRefundNo,
                                       MerchantPropertyReader merchantPropertyReader) {
        String host = getHost(merchantPropertyReader.openTestModel(),merchantPropertyReader.openHKNetModel());
        return host + "/v3/merchants/" + merchantPropertyReader.getMERCHANT_ID() + "/refunds/" + merchantRefundNo;
    }

    public static String getCancelPayUrl(String merchantTransactionId,
                                         MerchantPropertyReader merchantPropertyReader) {
        String host = getHost(merchantPropertyReader.openTestModel(),merchantPropertyReader.openHKNetModel());
        return host + "/v3/merchants/" + merchantPropertyReader.getMERCHANT_ID() + "/payments/" + merchantTransactionId + "/cancelpay";
    }

    public static String getShippingUploadUrl(String merchantTransactionId,
                                              MerchantPropertyReader merchantPropertyReader) {
        String host = getHost(merchantPropertyReader.openTestModel(),merchantPropertyReader.openHKNetModel());
        return host + "/v3/merchants/" + merchantPropertyReader.getMERCHANT_ID() + "/payments/" + merchantTransactionId + "/shipments";
    }

    public static String getIFrameTokenUrl(MerchantPropertyReader merchantPropertyReader) {
        String host = getHost(merchantPropertyReader.openTestModel(),merchantPropertyReader.openHKNetModel());
        return host + "/v3/merchants/" + merchantPropertyReader.getMERCHANT_ID() + "/token";
    }


    public static String getUnbindTokenUrl(MerchantPropertyReader merchantPropertyReader) {
        String host = getHost(merchantPropertyReader.openTestModel(),merchantPropertyReader.openHKNetModel());
        return host + "/v3/merchants/" + merchantPropertyReader.getMERCHANT_ID() + "/unbindToken";
    }


    public static String getTokenUrl(MerchantPropertyReader merchantPropertyReader) {
        String host = getHost(merchantPropertyReader.openTestModel(),merchantPropertyReader.openHKNetModel());
        return host + "/v3/merchants/" + merchantPropertyReader.getMERCHANT_ID() + "/token";
    }

    private static String getHost(boolean openTestModel,boolean openHKNetModel) {
        if (openTestModel){
            return GlobalpayConstants.TEST_HOST;
        }

        if (openHKNetModel){
            return GlobalpayConstants.HK_PROD_HOST;
        } else {
            return GlobalpayConstants.PROD_HOST;
        }
    }

    public static boolean checkUrl(String url) {
        return !ISOUtil.isNullOrEmpty(url)
                && Validator.validateLength(url, 1024, 1)
                && url.startsWith("http");
    }

    public static String getSign(Map<String, String> headers) {
        return headers.get(GlobalpayConstants.SIGNATURE);
    }
}
