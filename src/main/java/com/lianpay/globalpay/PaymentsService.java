package com.lianpay.globalpay;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lianpay.globalpay.client.DefaultHttpClient;
import com.lianpay.globalpay.client.HttpClient;
import com.lianpay.globalpay.constants.GlobalpayConstants;
import com.lianpay.globalpay.domain.ApiResult;
import com.lianpay.globalpay.domain.ImmutablePair;
import com.lianpay.globalpay.domain.bean.ParamValidateRes;
import com.lianpay.globalpay.domain.request.PaymentsRequest;
import com.lianpay.globalpay.domain.response.PaymentsResponse;
import com.lianpay.globalpay.exception.HttpClientException;
import com.lianpay.globalpay.exception.ParamCheckFailException;
import com.lianpay.globalpay.exception.SignException;
import com.lianpay.globalpay.exception.VerifySignFailException;
import com.lianpay.globalpay.reader.MerchantPropertyReader;
import com.lianpay.globalpay.utils.ISOUtil;
import com.lianpay.globalpay.utils.JacksonUtils;
import com.lianpay.globalpay.utils.SignUtil;

import java.util.Map;

public class PaymentsService extends BaseService {

    public ApiResult<PaymentsResponse> sendPaymentRequest(PaymentsRequest paymentsRequest, MerchantPropertyReader merchantPropertyReader)
            throws ParamCheckFailException, SignException, VerifySignFailException, HttpClientException {
        checkPayRequestParamsWithException(paymentsRequest, merchantPropertyReader);
        ImmutablePair<Map<String, String>, PaymentsRequest> paymentHeadersAndRequest = getPaymentHeadersAndRequest(paymentsRequest, merchantPropertyReader);
        return doSendPaymentRequest(paymentHeadersAndRequest.getLeft(), paymentHeadersAndRequest.getRight(), merchantPropertyReader);
    }

    public void checkPayRequestParamsWithException(PaymentsRequest paymentsRequest, MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException {
        ParamValidateRes paramValidateRes = checkPayRequestParams(paymentsRequest, merchantPropertyReader);
        if (paramValidateRes != null && !paramValidateRes.getValidateErrorList().isEmpty()) {
            throw new ParamCheckFailException(paramValidateRes.getValidateErrorList());
        }
    }

    public ParamValidateRes checkPayRequestParams(PaymentsRequest paymentsRequest, MerchantPropertyReader merchantPropertyReader) {
        return requestFormatterCheck.generateAndValidatePayRequestParams(paymentsRequest, merchantPropertyReader);
    }

    public ImmutablePair<Map<String,String>, PaymentsRequest> getPaymentHeadersAndRequest(PaymentsRequest paymentsRequest, MerchantPropertyReader merchantPropertyReader) throws SignException {
        return doGetPaymentHeadersAndRequest(paymentsRequest, merchantPropertyReader);
    }

    private ImmutablePair<Map<String,String>, PaymentsRequest> doGetPaymentHeadersAndRequest(PaymentsRequest paymentsRequest, MerchantPropertyReader merchantPropertyReader) throws SignException {
        String merchantPrivateKey = merchantPropertyReader.getMERCHANT_SIGN_KEY();
        String sign = SignUtil.addJsonStringSign(JacksonUtils.toJsonString(paymentsRequest), merchantPrivateKey, merchantPropertyReader.getAlgorithm(), merchantPropertyReader.openDebuggerLog());
        return ImmutablePair.of(generateHeaders(sign, merchantPropertyReader.getSIGN_TYPE()), paymentsRequest);
    }

    public ApiResult<PaymentsResponse> doSendPaymentRequest(Map<String,String> headers, PaymentsRequest paymentsRequest,
                                                            MerchantPropertyReader merchantPropertyReader) throws VerifySignFailException, HttpClientException {
        HttpClient.HttpClientResponse httpClientResponse = DefaultHttpClient.httpClientHolder.postJsonRequestNew(
                ISOUtil.getPaymentsUrl(merchantPropertyReader), JacksonUtils.toJsonString(paymentsRequest), headers, merchantPropertyReader.openDebuggerLog());
        if (httpClientResponse.isSucessFul()) {
            SignUtil.checkSign(httpClientResponse.getHeader(GlobalpayConstants.SIGNATURE),
                    httpClientResponse.getData(), merchantPropertyReader.getLL_SIGN_KEY(), merchantPropertyReader.getAlgorithm());
        }
        return JacksonUtils.parseObject(httpClientResponse.getData(), new TypeReference<ApiResult<PaymentsResponse>>(){});
    }

}
