package com.lianpay.globalpay;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lianpay.globalpay.client.DefaultHttpClient;
import com.lianpay.globalpay.client.HttpClient;
import com.lianpay.globalpay.constants.GlobalpayConstants;
import com.lianpay.globalpay.domain.ApiResult;
import com.lianpay.globalpay.domain.ImmutablePair;
import com.lianpay.globalpay.domain.bean.ParamValidateRes;
import com.lianpay.globalpay.domain.request.ShipmentRequest;
import com.lianpay.globalpay.exception.HttpClientException;
import com.lianpay.globalpay.exception.ParamCheckFailException;
import com.lianpay.globalpay.exception.SignException;
import com.lianpay.globalpay.exception.VerifySignFailException;
import com.lianpay.globalpay.reader.MerchantPropertyReader;
import com.lianpay.globalpay.utils.ISOUtil;
import com.lianpay.globalpay.utils.JacksonUtils;
import com.lianpay.globalpay.utils.SignUtil;

import java.util.Map;

public class ShipmentsService extends BaseService {
    public ApiResult<?> sendShipmentsRequest(ShipmentRequest request, MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException, SignException, VerifySignFailException, HttpClientException {
        checkShipmentRequestWithException(request, merchantPropertyReader);
        ImmutablePair<Map<String, String>, ShipmentRequest> shipmentHeadersAndRequest = getShipmentHeadersAndRequest(request, merchantPropertyReader);
        return doSendShipmentRequest(shipmentHeadersAndRequest.getLeft(), shipmentHeadersAndRequest.getRight(), merchantPropertyReader);
    }

    private void checkShipmentRequestWithException(ShipmentRequest request, MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException {
        ParamValidateRes paramValidateRes = checkShipmentRequestParams(request, merchantPropertyReader);
        if (paramValidateRes != null && !paramValidateRes.getValidateErrorList().isEmpty()) {
            throw new ParamCheckFailException(paramValidateRes.getValidateErrorList());
        }
    }

    private ParamValidateRes checkShipmentRequestParams(ShipmentRequest request, MerchantPropertyReader merchantPropertyReader) {
        return requestFormatterCheck.generateAndValidateShipmentsRequestParams(request, merchantPropertyReader);
    }

    public ImmutablePair<Map<String,String>, ShipmentRequest> getShipmentHeadersAndRequest(ShipmentRequest request, MerchantPropertyReader merchantPropertyReader) throws SignException {
        return doGetShipmentHeadersAndRequest(request, merchantPropertyReader);
    }

    private ImmutablePair<Map<String, String>, ShipmentRequest> doGetShipmentHeadersAndRequest(ShipmentRequest request, MerchantPropertyReader merchantPropertyReader) throws SignException {
        String merchantPrivateKey = merchantPropertyReader.getMERCHANT_SIGN_KEY();
        String sign = SignUtil.addJsonStringSign(JacksonUtils.toJsonString(request), merchantPrivateKey, merchantPropertyReader.getAlgorithm(), merchantPropertyReader.openDebuggerLog());
        return ImmutablePair.of(generateHeaders(sign, merchantPropertyReader.getSIGN_TYPE()), request);
    }

    public ApiResult<?> doSendShipmentRequest(Map<String,String> headers, ShipmentRequest shipmentRequest,
                                              MerchantPropertyReader merchantPropertyReader) throws VerifySignFailException, HttpClientException {
        HttpClient.HttpClientResponse httpClientResponse = DefaultHttpClient.httpClientHolder.postJsonRequestNew(
                ISOUtil.getShippingUploadUrl(shipmentRequest.getMerchantTransactionId(), merchantPropertyReader),
                JacksonUtils.toJsonString(shipmentRequest), headers, merchantPropertyReader.openDebuggerLog());
        if (httpClientResponse.isSucessFul()) {
            SignUtil.checkSign(httpClientResponse.getHeader(GlobalpayConstants.SIGNATURE),
                    httpClientResponse.getData(), merchantPropertyReader.getLL_SIGN_KEY(), merchantPropertyReader.getAlgorithm());
        }
        return JacksonUtils.parseObject(httpClientResponse.getData(), new TypeReference<ApiResult<?>>(){});
    }
}
