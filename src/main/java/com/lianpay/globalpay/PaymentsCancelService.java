package com.lianpay.globalpay;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lianpay.globalpay.client.DefaultHttpClient;
import com.lianpay.globalpay.client.HttpClient;
import com.lianpay.globalpay.constants.GlobalpayConstants;
import com.lianpay.globalpay.domain.ApiResult;
import com.lianpay.globalpay.domain.bean.ParamValidateRes;
import com.lianpay.globalpay.domain.response.CancelPayResponse;
import com.lianpay.globalpay.exception.HttpClientException;
import com.lianpay.globalpay.exception.ParamCheckFailException;
import com.lianpay.globalpay.exception.SignException;
import com.lianpay.globalpay.exception.VerifySignFailException;
import com.lianpay.globalpay.reader.MerchantPropertyReader;
import com.lianpay.globalpay.utils.ISOUtil;
import com.lianpay.globalpay.utils.JacksonUtils;
import com.lianpay.globalpay.utils.SignUtil;

import java.util.Map;

public class PaymentsCancelService extends BaseService {
    public ApiResult<CancelPayResponse> sendPaymentCancelRequest(String merchantTransactionId,
                                                                 MerchantPropertyReader merchantPropertyReader) throws SignException, VerifySignFailException, ParamCheckFailException, HttpClientException {
        checkPaymentCancelRequestParamsWithException(merchantTransactionId, merchantPropertyReader);
        Map<String, String> cancelRequestHeaders = getPathRequestHeaders(merchantTransactionId, merchantPropertyReader);
        return doSendPaymentCancelQueryRequest(cancelRequestHeaders, merchantTransactionId, merchantPropertyReader);
    }

    public void checkPaymentCancelRequestParamsWithException(String merchantTransactionId,
                                                             MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException {
        ParamValidateRes paramValidateRes = requestFormatterCheck.validatePathRequestParams(merchantTransactionId, merchantPropertyReader);
        if (paramValidateRes != null && !paramValidateRes.getValidateErrorList().isEmpty()) {
            throw new ParamCheckFailException(paramValidateRes.getValidateErrorList());
        }
    }

    private ApiResult<CancelPayResponse> doSendPaymentCancelQueryRequest(Map<String, String> headers, String merchantTransactionId,
                                                                         MerchantPropertyReader merchantPropertyReader) throws VerifySignFailException, HttpClientException {
        HttpClient.HttpClientResponse httpClientResponse = DefaultHttpClient.httpClientHolder.getJsonRequestResultAll(
                ISOUtil.getCancelPayUrl(merchantTransactionId, merchantPropertyReader), ISOUtil.EMPTY_STRING, headers, merchantPropertyReader.openDebuggerLog());
        if (httpClientResponse.isSucessFul()) {
            SignUtil.checkSign(httpClientResponse.getHeader(GlobalpayConstants.SIGNATURE),
                    httpClientResponse.getData(), merchantPropertyReader.getLL_SIGN_KEY(), merchantPropertyReader.getAlgorithm());
        }
        return JacksonUtils.parseObject(httpClientResponse.getData(), new TypeReference<ApiResult<CancelPayResponse>>(){});
    }
}
