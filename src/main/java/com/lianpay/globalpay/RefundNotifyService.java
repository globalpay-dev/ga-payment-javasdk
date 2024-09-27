package com.lianpay.globalpay;

import com.lianpay.globalpay.domain.bean.ParamValidateRes;
import com.lianpay.globalpay.domain.request.RefundNotifyRequest;
import com.lianpay.globalpay.exception.ParamCheckFailException;
import com.lianpay.globalpay.exception.VerifySignFailException;
import com.lianpay.globalpay.reader.MerchantPropertyReader;
import com.lianpay.globalpay.utils.JacksonUtils;

import java.util.Map;

public class RefundNotifyService extends BaseService {
    public RefundNotifyRequest checkNotifySignAndGetRefundNotifyRequest(Map<String, String> headers,
                                                                        String requestJsonBody,
                                                                        MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException, VerifySignFailException {
        checkNotifyRequestWithException(merchantPropertyReader);
        checkNotifySign(headers, requestJsonBody, merchantPropertyReader);
        return JacksonUtils.parseObject(requestJsonBody, RefundNotifyRequest.class);
    }

    public void checkNotifyRequestWithException(MerchantPropertyReader merchantPropertyReader) throws ParamCheckFailException {
        ParamValidateRes paramValidateRes = requestFormatterCheck.checkPropertyParams(merchantPropertyReader);
        if (paramValidateRes != null && !paramValidateRes.getValidateErrorList().isEmpty()) {
            throw new ParamCheckFailException(paramValidateRes.getValidateErrorList());
        }
    }
}
