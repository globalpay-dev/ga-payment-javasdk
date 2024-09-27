package com.lianpay.globalpay;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lianpay.globalpay.client.DefaultHttpClient;
import com.lianpay.globalpay.client.HttpClient;
import com.lianpay.globalpay.constants.GlobalpayConstants;
import com.lianpay.globalpay.domain.ApiResult;
import com.lianpay.globalpay.domain.bean.ParamValidateRes;
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

public class RefundQueryService extends BaseService {
    public ApiResult<RefundResponse> sendRefundQueryRequest(String merchantTransactionId,
                                                            MerchantPropertyReader merchantPropertyReader) throws SignException, VerifySignFailException, ParamCheckFailException, HttpClientException {
        checkRefundQueryRequestParamsWithException(merchantTransactionId, merchantPropertyReader);
        Map<String, String> refundQueryHeaders = getPathRequestHeaders(merchantTransactionId, merchantPropertyReader);
        return doSendRefundQueryRequest(refundQueryHeaders, merchantTransactionId, merchantPropertyReader);
    }

    public void checkRefundQueryRequestParamsWithException(String merchantTransactionId,
                                                           MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException {
        ParamValidateRes paramValidateRes = requestFormatterCheck.validatePathRequestParams(merchantTransactionId, merchantPropertyReader);
        if (paramValidateRes != null && !paramValidateRes.getValidateErrorList().isEmpty()) {
            throw new ParamCheckFailException(paramValidateRes.getValidateErrorList());
        }
    }

    public ApiResult<RefundResponse> doSendRefundQueryRequest(Map<String,String> headers, String merchantTransactionId,
                                                                MerchantPropertyReader merchantPropertyReader) throws VerifySignFailException, HttpClientException {
        String url = ISOUtil.getRefundsQueryUrl(merchantTransactionId, merchantPropertyReader);
        HttpClient.HttpClientResponse httpClientResponse = DefaultHttpClient.httpClientHolder.getJsonRequestResultAll(url, ISOUtil.EMPTY_STRING, headers, merchantPropertyReader.openDebuggerLog());
        if (httpClientResponse.isSucessFul()) {
            SignUtil.checkSign(httpClientResponse.getHeader(GlobalpayConstants.SIGNATURE),
                    httpClientResponse.getData(), merchantPropertyReader.getLL_SIGN_KEY(), merchantPropertyReader.getAlgorithm());
        }
        return JacksonUtils.parseObject(httpClientResponse.getData(), new TypeReference<ApiResult<RefundResponse>>(){});
    }

}