package com.lianpay.globalpay;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lianpay.globalpay.client.DefaultHttpClient;
import com.lianpay.globalpay.client.HttpClient;
import com.lianpay.globalpay.constants.GlobalpayConstants;
import com.lianpay.globalpay.domain.ApiResult;
import com.lianpay.globalpay.domain.bean.ParamValidateRes;
import com.lianpay.globalpay.exception.HttpClientException;
import com.lianpay.globalpay.exception.ParamCheckFailException;
import com.lianpay.globalpay.exception.SignException;
import com.lianpay.globalpay.exception.VerifySignFailException;
import com.lianpay.globalpay.reader.MerchantPropertyReader;
import com.lianpay.globalpay.utils.ISOUtil;
import com.lianpay.globalpay.utils.JacksonUtils;
import com.lianpay.globalpay.utils.SignUtil;

import java.util.HashMap;
import java.util.Map;

public class IFrameTokenService extends BaseService {
    public ApiResult<String> sendIFrameTokenRequest(MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException, SignException, VerifySignFailException, HttpClientException {
        checkIFrameTokenRequestParamsWithException(merchantPropertyReader);
        Map<String, String> iFrameTokenHeaders = getIFrameTokenHeaders(merchantPropertyReader);
        return doSendIFrameTokenRequest(iFrameTokenHeaders, merchantPropertyReader);
    }

    private void checkIFrameTokenRequestParamsWithException(MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException {
        ParamValidateRes paramValidateRes = checkIFrameTokenRequestParams(merchantPropertyReader);
        if (paramValidateRes != null && !paramValidateRes.getValidateErrorList().isEmpty()) {
            throw new ParamCheckFailException(paramValidateRes.getValidateErrorList());
        }
    }

    public ParamValidateRes checkIFrameTokenRequestParams(MerchantPropertyReader merchantPropertyReader) {
        return requestFormatterCheck.checkPropertyParams(merchantPropertyReader);
    }

    public Map<String, String> getIFrameTokenHeaders(MerchantPropertyReader merchantPropertyReader) throws SignException {
        String merchantPrivateKey = merchantPropertyReader.getMERCHANT_SIGN_KEY();
        String timestamp = getTimestamp();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("merchant_id", merchantPropertyReader.getMERCHANT_ID());
        params.put("timestamp", timestamp);
        String sign = SignUtil.addMapSign(params, merchantPrivateKey, merchantPropertyReader.getAlgorithm(), merchantPropertyReader.openDebuggerLog());
        return generateHeaders(sign, timestamp, merchantPropertyReader.getSIGN_TYPE(), merchantPropertyReader.getAPI_VERSION());
    }

    private ApiResult<String> doSendIFrameTokenRequest(Map<String, String> headers, MerchantPropertyReader merchantPropertyReader)
            throws VerifySignFailException, HttpClientException {
        String url = ISOUtil.getIFrameTokenUrl(merchantPropertyReader);
        HttpClient.HttpClientResponse httpClientResponse = DefaultHttpClient.httpClientHolder.getJsonRequestResultAll(url, ISOUtil.EMPTY_STRING, headers, merchantPropertyReader.openDebuggerLog());
        if (httpClientResponse.isSucessFul()) {
            SignUtil.checkSign(httpClientResponse.getHeader(GlobalpayConstants.SIGNATURE),
                    httpClientResponse.getData(), merchantPropertyReader.getLL_SIGN_KEY(), merchantPropertyReader.getAlgorithm());
        }
        return JacksonUtils.parseObject(httpClientResponse.getData(), new TypeReference<ApiResult<String>>(){});
    }
}
