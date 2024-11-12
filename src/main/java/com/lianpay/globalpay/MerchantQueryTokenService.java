package com.lianpay.globalpay;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lianpay.globalpay.client.DefaultHttpClient;
import com.lianpay.globalpay.client.HttpClient;
import com.lianpay.globalpay.constants.GlobalpayConstants;
import com.lianpay.globalpay.domain.ApiResult;
import com.lianpay.globalpay.domain.ImmutablePair;
import com.lianpay.globalpay.domain.bean.ParamValidateRes;
import com.lianpay.globalpay.domain.request.CardTokenRequest;
import com.lianpay.globalpay.domain.response.MerchantTokenResponse;
import com.lianpay.globalpay.exception.HttpClientException;
import com.lianpay.globalpay.exception.ParamCheckFailException;
import com.lianpay.globalpay.exception.SignException;
import com.lianpay.globalpay.exception.VerifySignFailException;
import com.lianpay.globalpay.reader.MerchantPropertyReader;
import com.lianpay.globalpay.utils.ISOUtil;
import com.lianpay.globalpay.utils.JacksonUtils;
import com.lianpay.globalpay.utils.SignUtil;

import java.util.Map;

public class MerchantQueryTokenService extends BaseService{

    public ApiResult<MerchantTokenResponse> sendQueryCardTokenRequest(CardTokenRequest cardTokenRequest, MerchantPropertyReader merchantPropertyReader)
            throws ParamCheckFailException, SignException, VerifySignFailException, HttpClientException {
        checkQuertCardTokenRequestWithException(cardTokenRequest, merchantPropertyReader);
        ImmutablePair<Map<String, String>, CardTokenRequest> cardTokenHeadersAndRequest = getQuerytCardTokenHeadersAndRequest(cardTokenRequest, merchantPropertyReader);
        return doSendQueryRequest(cardTokenHeadersAndRequest.getLeft(), cardTokenHeadersAndRequest.getRight(), merchantPropertyReader);
    }


    private void checkQuertCardTokenRequestWithException(CardTokenRequest request, MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException {
        ParamValidateRes paramValidateRes = checkCardTokenRequestParams(request, merchantPropertyReader);
        if (paramValidateRes != null && !paramValidateRes.getValidateErrorList().isEmpty()) {
            throw new ParamCheckFailException(paramValidateRes.getValidateErrorList());
        }
    }
    public ParamValidateRes checkCardTokenRequestParams(CardTokenRequest cardTokenRequest, MerchantPropertyReader merchantPropertyReader) {
        return requestFormatterCheck.generateAndValidateCardTokenRequestParams(cardTokenRequest, merchantPropertyReader);
    }

    public ImmutablePair<Map<String,String>, CardTokenRequest> getQuerytCardTokenHeadersAndRequest(CardTokenRequest cardTokenRequest, MerchantPropertyReader merchantPropertyReader) throws SignException {
        return getQueryHeadersAndRequest(cardTokenRequest, merchantPropertyReader);
    }

    private ImmutablePair<Map<String,String>, CardTokenRequest> getQueryHeadersAndRequest(CardTokenRequest cardTokenRequest, MerchantPropertyReader merchantPropertyReader) throws SignException {
        String merchantPrivateKey = merchantPropertyReader.getMERCHANT_SIGN_KEY();
        String sign = SignUtil.addJsonStringSign(JacksonUtils.toJsonString(cardTokenRequest), merchantPrivateKey, merchantPropertyReader.getAlgorithm(), merchantPropertyReader.openDebuggerLog());
        return ImmutablePair.of(generateHeaders(sign, merchantPropertyReader.getSIGN_TYPE()), cardTokenRequest);
    }

    public ApiResult<MerchantTokenResponse> doSendQueryRequest(Map<String,String> headers, CardTokenRequest cardTokenRequest,
                                             MerchantPropertyReader merchantPropertyReader) throws VerifySignFailException, HttpClientException {
        HttpClient.HttpClientResponse httpClientResponse = DefaultHttpClient.httpClientHolder.postJsonRequestNew(
                ISOUtil.getQueryTokenUrl(merchantPropertyReader), JacksonUtils.toJsonString(cardTokenRequest), headers, merchantPropertyReader.openDebuggerLog());
        if (httpClientResponse.isSucessFul()) {
            SignUtil.checkSign(httpClientResponse.getHeader(GlobalpayConstants.SIGNATURE),
                    httpClientResponse.getData(), merchantPropertyReader.getLL_SIGN_KEY(), merchantPropertyReader.getAlgorithm());
        }
        return JacksonUtils.parseObject(httpClientResponse.getData(), new TypeReference<ApiResult<MerchantTokenResponse>>(){});
    }
}
