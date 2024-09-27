package com.lianpay.globalpay.validator;

import com.lianpay.globalpay.domain.bean.ParamValidateRes;
import com.lianpay.globalpay.domain.request.CardTokenRequest;
import com.lianpay.globalpay.domain.request.PaymentsRequest;
import com.lianpay.globalpay.domain.request.RefundRequest;
import com.lianpay.globalpay.domain.request.ShipmentRequest;
import com.lianpay.globalpay.reader.MerchantPropertyReader;
import com.lianpay.globalpay.utils.ISOUtil;
import com.lianpay.globalpay.utils.LoggerUtil;
import org.apache.log4j.Logger;


public class RequestFormatterCheck extends BaseRequestFormatterCheck {
    private final Logger LOGGER = Logger.getLogger(RequestFormatterCheck.class);

    public ParamValidateRes checkPropertyParams(MerchantPropertyReader merchantPropertyReader) {
        return merchantPropertyReader.checkPropertyParams();
    }

    public ParamValidateRes generateAndValidatePayRequestParams(PaymentsRequest paymentsRequest, MerchantPropertyReader merchantPropertyReader) {
        /* 校验配置文件参数 */
        ParamValidateRes paramValidateRes = checkPropertyParams(merchantPropertyReader);
        paymentsRequest.setMerchantId(merchantPropertyReader.getMERCHANT_ID());
        paymentsRequest.setSubMerchantId(merchantPropertyReader.getSUB_MERCHANT_ID());
        /* 校验基类参数 */
        paramValidateRes.addValidateErrors(checkPayBaseRequest(paymentsRequest, merchantPropertyReader));
        return paramValidateRes;
    }

    public ParamValidateRes validatePathRequestParams(String merchantTransactionId,
                                                      MerchantPropertyReader merchantPropertyReader) {
        /* 校验配置文件参数 */
        ParamValidateRes paramValidateRes = checkPropertyParams(merchantPropertyReader);
        if (ISOUtil.isNullOrEmpty(merchantTransactionId)
                || !Validator.validateLength(merchantTransactionId, 64, 1)) {
            LoggerUtil.error(LOGGER, merchantPropertyReader, "merchantTransactionId is incorrect");
            paramValidateRes.addValidateError("merchantTransactionId is incorrect");
        }
        return paramValidateRes;
    }

    public ParamValidateRes generateAndValidateRefundRequestParams(RefundRequest request,
                                                                   MerchantPropertyReader merchantPropertyReader) {
        /* 校验配置文件参数 */
        ParamValidateRes paramValidateRes = checkPropertyParams(merchantPropertyReader);
        request.setMerchantId(merchantPropertyReader.getMERCHANT_ID());
        request.setSubMerchantId(merchantPropertyReader.getSUB_MERCHANT_ID());
        //TODO yumz
        return paramValidateRes;
    }

    public ParamValidateRes generateAndValidateShipmentsRequestParams(ShipmentRequest request,
                                                                      MerchantPropertyReader merchantPropertyReader) {
        /* 校验配置文件参数 */
        ParamValidateRes paramValidateRes = checkPropertyParams(merchantPropertyReader);
        request.setMerchantId(merchantPropertyReader.getMERCHANT_ID());
        request.setSubMerchantId(merchantPropertyReader.getSUB_MERCHANT_ID());
        //TODO yumz
        return paramValidateRes;
    }


    public ParamValidateRes generateAndValidateCardTokenRequestParams(CardTokenRequest cardTokenRequest, MerchantPropertyReader merchantPropertyReader) {
        /* 校验配置文件参数 */
        ParamValidateRes paramValidateRes = checkPropertyParams(merchantPropertyReader);
        cardTokenRequest.setMerchantId(merchantPropertyReader.getMERCHANT_ID());
        cardTokenRequest.setSubMerchantId(merchantPropertyReader.getSUB_MERCHANT_ID());
        return paramValidateRes;
    }
}
