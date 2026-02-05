package com.lianpay.globalpay;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lianpay.globalpay.client.DefaultHttpClient;
import com.lianpay.globalpay.client.HttpClient;
import com.lianpay.globalpay.constants.GlobalpayConstants;
import com.lianpay.globalpay.domain.ApiResult;
import com.lianpay.globalpay.domain.ImmutablePair;
import com.lianpay.globalpay.domain.bean.ParamValidateRes;
import com.lianpay.globalpay.domain.request.PaymentQueryByPostRequest;
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

public class PaymentsQueryService extends BaseService {
    public ApiResult<PaymentsResponse> sendPaymentQueryRequest(String merchantTransactionId,
                                                               MerchantPropertyReader merchantPropertyReader) throws SignException, VerifySignFailException, ParamCheckFailException, HttpClientException {
        checkPayQueryRequestParamsWithException(merchantTransactionId, merchantPropertyReader);
        Map<String, String> paymentQueryHeaders = getPathRequestHeaders(merchantTransactionId, merchantPropertyReader);
        return doSendPaymentsQueryRequest(paymentQueryHeaders, merchantTransactionId, merchantPropertyReader);
    }

    public void checkPayQueryRequestParamsWithException(String merchantTransactionId,
                                                        MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException {
        ParamValidateRes paramValidateRes = requestFormatterCheck.validatePathRequestParams(merchantTransactionId, merchantPropertyReader);
        if (paramValidateRes != null && !paramValidateRes.getValidateErrorList().isEmpty()) {
            throw new ParamCheckFailException(paramValidateRes.getValidateErrorList());
        }
    }

    public ApiResult<PaymentsResponse> doSendPaymentsQueryRequest(Map<String,String> headers, String merchantTransactionId,
                                                                  MerchantPropertyReader merchantPropertyReader) throws VerifySignFailException, HttpClientException {
        String url = ISOUtil.getPaymentsQueryUrl(merchantTransactionId, merchantPropertyReader);
        HttpClient.HttpClientResponse httpClientResponse = DefaultHttpClient.httpClientHolder.getJsonRequestResultAll(url, ISOUtil.EMPTY_STRING, headers, merchantPropertyReader.openDebuggerLog());
        if (httpClientResponse.isSucessFul()) {
            SignUtil.checkSign(httpClientResponse.getHeader(GlobalpayConstants.SIGNATURE),
                    httpClientResponse.getData(), merchantPropertyReader.getLL_SIGN_KEY(), merchantPropertyReader.getAlgorithm());
        }
        return JacksonUtils.parseObject(httpClientResponse.getData(), new TypeReference<ApiResult<PaymentsResponse>>(){});
    }

    /**
     * 发送支付查询请求（POST方式，支持ARN查询）
     * 
     * @param queryRequest 支付查询请求对象
     * @param merchantPropertyReader 商户配置读取器
     * @return 支付查询响应结果
     * @throws ParamCheckFailException 参数校验失败异常
     * @throws SignException 签名异常
     * @throws VerifySignFailException 验签失败异常
     * @throws HttpClientException HTTP客户端异常
     */
    public ApiResult<PaymentsResponse> sendPaymentQueryByPostRequest(PaymentQueryByPostRequest queryRequest,
                                                                      MerchantPropertyReader merchantPropertyReader,String verison)
            throws ParamCheckFailException, SignException, VerifySignFailException, HttpClientException {
        checkPayQueryByPostRequestParamsWithException(queryRequest, merchantPropertyReader);
        ImmutablePair<Map<String, String>, PaymentQueryByPostRequest> headersAndRequest = 
                getPaymentQueryByPostHeadersAndRequest(queryRequest, merchantPropertyReader);
        return doSendPaymentQueryByPostRequest(headersAndRequest.getLeft(), headersAndRequest.getRight(), merchantPropertyReader,verison);
    }

    /**
     * 校验POST方式查询请求参数
     */
    public void checkPayQueryByPostRequestParamsWithException(PaymentQueryByPostRequest queryRequest,
                                                               MerchantPropertyReader merchantPropertyReader)
            throws ParamCheckFailException {
        ParamValidateRes paramValidateRes = requestFormatterCheck.validatePaymentQueryByPostRequestParams(queryRequest, merchantPropertyReader);
        if (paramValidateRes != null && !paramValidateRes.getValidateErrorList().isEmpty()) {
            throw new ParamCheckFailException(paramValidateRes.getValidateErrorList());
        }
    }

    /**
     * 获取POST查询请求头和请求体
     */
    public ImmutablePair<Map<String, String>, PaymentQueryByPostRequest> getPaymentQueryByPostHeadersAndRequest(
            PaymentQueryByPostRequest queryRequest, MerchantPropertyReader merchantPropertyReader) throws SignException {
        return doGetPaymentQueryByPostHeadersAndRequest(queryRequest, merchantPropertyReader);
    }

    /**
     * 构建POST查询请求头和请求体
     */
    private ImmutablePair<Map<String, String>, PaymentQueryByPostRequest> doGetPaymentQueryByPostHeadersAndRequest(
            PaymentQueryByPostRequest queryRequest, MerchantPropertyReader merchantPropertyReader) throws SignException {
        queryRequest.setMerchantId(merchantPropertyReader.getMERCHANT_ID());
        String merchantPrivateKey = merchantPropertyReader.getMERCHANT_SIGN_KEY();
        String sign = SignUtil.addJsonStringSign(JacksonUtils.toJsonString(queryRequest), merchantPrivateKey,
                merchantPropertyReader.getAlgorithm(), merchantPropertyReader.openDebuggerLog());
        return ImmutablePair.of(generateHeaders(sign, merchantPropertyReader.getSIGN_TYPE()), queryRequest);
    }

    /**
     * 执行POST方式的支付查询请求
     */
    public ApiResult<PaymentsResponse> doSendPaymentQueryByPostRequest(Map<String, String> headers,
                                                                        PaymentQueryByPostRequest queryRequest,
                                                                        MerchantPropertyReader merchantPropertyReader,String version)
            throws VerifySignFailException, HttpClientException {
        headers.put("accept-version",version);
        String url = ISOUtil.getPaymentsQueryByPostUrl(merchantPropertyReader);
        HttpClient.HttpClientResponse httpClientResponse = DefaultHttpClient.httpClientHolder.postJsonRequestNew(
                url, JacksonUtils.toJsonString(queryRequest), headers, merchantPropertyReader.openDebuggerLog());
        if (httpClientResponse.isSucessFul()) {
            SignUtil.checkSign(httpClientResponse.getHeader(GlobalpayConstants.SIGNATURE),
                    httpClientResponse.getData(), merchantPropertyReader.getLL_SIGN_KEY(), merchantPropertyReader.getAlgorithm());
        }
        return JacksonUtils.parseObject(httpClientResponse.getData(), new TypeReference<ApiResult<PaymentsResponse>>(){});
    }

}
