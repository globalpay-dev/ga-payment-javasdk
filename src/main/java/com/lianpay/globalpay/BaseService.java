package com.lianpay.globalpay;

import com.lianpay.globalpay.constants.GlobalpayConstants;
import com.lianpay.globalpay.domain.response.NotifyResponse;
import com.lianpay.globalpay.exception.SignException;
import com.lianpay.globalpay.exception.VerifySignFailException;
import com.lianpay.globalpay.reader.MerchantPropertyReader;
import com.lianpay.globalpay.utils.DateUtils;
import com.lianpay.globalpay.utils.ISOUtil;
import com.lianpay.globalpay.utils.SignUtil;
import com.lianpay.globalpay.validator.RequestFormatterCheck;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BaseService {
    protected final RequestFormatterCheck requestFormatterCheck = new RequestFormatterCheck();

    public Map<String, String> generateHeaders(String signature, String signType, String apiVersion) {
        return generateHeaders(signature, getTimestamp(), signType, apiVersion);
    }

    public Map<String, String> generateHeaders(String signature, String timestamp, String signType, String apiVersion) {
        Map<String, String> globalpayDefaultHeaders = GlobalpayConstants.GLOBALPAY_DEFAULT_HEADERS;
        globalpayDefaultHeaders.put(GlobalpayConstants.SIGN_TYPE, signType);
        globalpayDefaultHeaders.put(GlobalpayConstants.SIGNATURE, signature);
        globalpayDefaultHeaders.put(GlobalpayConstants.TIMESTAMP, timestamp);
        if(apiVersion != null){
            globalpayDefaultHeaders.put(GlobalpayConstants.ACCEPT_VERSION, apiVersion);
        }
        return globalpayDefaultHeaders;
    }

    public String getTimestamp() {
        SimpleDateFormat formatter = DateUtils.DateFormatHolder.formatFor(GlobalpayConstants.TIMESTAMP_FORMAT);
        return formatter.format(new Date());
    }

    public Map<String, String> getPathRequestHeaders(String merchantTransactionId,
                                                     MerchantPropertyReader merchantPropertyReader) throws SignException {
        String merchantPrivateKey = merchantPropertyReader.getMERCHANT_SIGN_KEY();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("merchant_id", merchantPropertyReader.getMERCHANT_ID());
        params.put("merchant_transaction_id", merchantTransactionId);
        String sign = SignUtil.addMapSign(params, merchantPrivateKey, merchantPropertyReader.getAlgorithm(), merchantPropertyReader.openDebuggerLog());
        return generateHeaders(sign, merchantPropertyReader.getSIGN_TYPE(), merchantPropertyReader.getAPI_VERSION());
    }

    public void checkNotifySign(Map<String, String> headers, String requestJsonBody,
                                MerchantPropertyReader merchantPropertyReader) throws VerifySignFailException {
        String sign = ISOUtil.getSign(headers);
        SignUtil.checkSign(sign, requestJsonBody, merchantPropertyReader.getLL_SIGN_KEY(),
                merchantPropertyReader.getAlgorithm());
    }

    public NotifyResponse getSuccessDealResponse() {
        NotifyResponse notifyResponse = new NotifyResponse();
        notifyResponse.setCode("200");
        notifyResponse.setMsg("success");
        return notifyResponse;
    }
}
