package com.lianpay.globalpay.validator;

import com.lianpay.globalpay.domain.bean.ParamValidateRes;
import com.lianpay.globalpay.domain.request.CardTokenRequest;
import com.lianpay.globalpay.domain.request.PaymentQueryByPostRequest;
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

    /**
     * 校验POST方式支付查询请求参数
     */
    public ParamValidateRes validatePaymentQueryByPostRequestParams(PaymentQueryByPostRequest queryRequest,
                                                                     MerchantPropertyReader merchantPropertyReader) {
        /* 校验配置文件参数 */
        ParamValidateRes paramValidateRes = checkPropertyParams(merchantPropertyReader);
        
        // 校验：merchant_transaction_id 和 arn 至少要有一个
        if (ISOUtil.isNullOrEmpty(queryRequest.getMerchantTransactionId()) 
                && ISOUtil.isNullOrEmpty(queryRequest.getArn())) {
            LoggerUtil.error(LOGGER, merchantPropertyReader, 
                    "At least one of 'merchant_transaction_id' or 'arn' must be provided");
            paramValidateRes.addValidateError("At least one of 'merchant_transaction_id' or 'arn' must be provided");
            return paramValidateRes;
        }
        
        // 如果提供了merchantTransactionId，校验其长度
        if (!ISOUtil.isNullOrEmpty(queryRequest.getMerchantTransactionId())
                && !Validator.validateLength(queryRequest.getMerchantTransactionId(), 64, 1)) {
            LoggerUtil.error(LOGGER, merchantPropertyReader, "merchantTransactionId is incorrect");
            paramValidateRes.addValidateError("merchantTransactionId is incorrect");
        }
        
        // 如果提供了arn，校验其长度
        if (!ISOUtil.isNullOrEmpty(queryRequest.getArn())
                && !Validator.validateLength(queryRequest.getArn(), 128, 1)) {
            LoggerUtil.error(LOGGER, merchantPropertyReader, "arn is incorrect");
            paramValidateRes.addValidateError("arn is incorrect");
        }
        
        return paramValidateRes;
    }
}
