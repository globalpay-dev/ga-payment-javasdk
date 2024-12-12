package com.lianpay.globalpay;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lianpay.globalpay.client.DefaultHttpClient;
import com.lianpay.globalpay.client.HttpClient;
import com.lianpay.globalpay.constants.GlobalpayConstants;
import com.lianpay.globalpay.domain.ApiResult;
import com.lianpay.globalpay.domain.ImmutablePair;
import com.lianpay.globalpay.domain.bean.ParamValidateRes;
import com.lianpay.globalpay.domain.request.RefundRequest;
import com.lianpay.globalpay.domain.response.RefundResponse;
import com.lianpay.globalpay.exception.HttpClientException;
import com.lianpay.globalpay.exception.ParamCheckFailException;
import com.lianpay.globalpay.exception.SignException;
import com.lianpay.globalpay.exception.VerifySignFailException;
import com.lianpay.globalpay.reader.MerchantPropertyReader;
import com.lianpay.globalpay.utils.ISOUtil;
import com.lianpay.globalpay.utils.JacksonUtils;
import com.lianpay.globalpay.utils.SignUtil;

import java.util.Map;

public class RefundService extends BaseService {
    public ApiResult<RefundResponse> sendRefundRequest(RefundRequest request, MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException, SignException, VerifySignFailException, HttpClientException {
        checkRefundRequestWithException(request, merchantPropertyReader);
        ImmutablePair<Map<String, String>, RefundRequest> refundHeadersAndRequest = getRefundHeadersAndRequest(request, merchantPropertyReader);
        return doSendRefundRequest(refundHeadersAndRequest.getLeft(), refundHeadersAndRequest.getRight(), merchantPropertyReader);
    }

    public void checkRefundRequestWithException(RefundRequest request, MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException {
        ParamValidateRes paramValidateRes = checkRefundRequestParams(request, merchantPropertyReader);
        if (paramValidateRes != null && !paramValidateRes.getValidateErrorList().isEmpty()) {
            throw new ParamCheckFailException(paramValidateRes.getValidateErrorList());
        }
    }

    public ParamValidateRes checkRefundRequestParams(RefundRequest request, MerchantPropertyReader merchantPropertyReader) {
        return requestFormatterCheck.generateAndValidateRefundRequestParams(request, merchantPropertyReader);
    }

    public ImmutablePair<Map<String,String>, RefundRequest> getRefundHeadersAndRequest(RefundRequest request, MerchantPropertyReader merchantPropertyReader) throws SignException {
        return doGetRefundHeadersAndRequest(request, merchantPropertyReader);
    }

    private ImmutablePair<Map<String,String>, RefundRequest> doGetRefundHeadersAndRequest(RefundRequest request, MerchantPropertyReader merchantPropertyReader) throws SignException {
        String merchantPrivateKey = merchantPropertyReader.getMERCHANT_SIGN_KEY();
        String sign = SignUtil.addJsonStringSign(JacksonUtils.toJsonString(request), merchantPrivateKey, merchantPropertyReader.getAlgorithm(), merchantPropertyReader.openDebuggerLog());
        return ImmutablePair.of(generateHeaders(sign, merchantPropertyReader.getSIGN_TYPE(), merchantPropertyReader.getAPI_VERSION()), request);
    }

    public ApiResult<RefundResponse> doSendRefundRequest(Map<String,String> headers, RefundRequest request,
                                                            MerchantPropertyReader merchantPropertyReader) throws VerifySignFailException, HttpClientException {
        HttpClient.HttpClientResponse httpClientResponse = DefaultHttpClient.httpClientHolder.postJsonRequestNew(
                ISOUtil.getRefundsUrl(request.getOriginalTransactionId(), merchantPropertyReader), JacksonUtils.toJsonString(request), headers, merchantPropertyReader.openDebuggerLog());
        if (httpClientResponse.isSucessFul()) {
            SignUtil.checkSign(httpClientResponse.getHeader(GlobalpayConstants.SIGNATURE),
                    httpClientResponse.getData(), merchantPropertyReader.getLL_SIGN_KEY(), merchantPropertyReader.getAlgorithm());
        }
        return JacksonUtils.parseObject(httpClientResponse.getData(), new TypeReference<ApiResult<RefundResponse>>(){});
    }
}
