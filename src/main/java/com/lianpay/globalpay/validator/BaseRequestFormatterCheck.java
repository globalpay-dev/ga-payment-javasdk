package com.lianpay.globalpay.validator;

import com.lianpay.globalpay.domain.request.BaseRequest;
import com.lianpay.globalpay.enums.CountryEnum;
import com.lianpay.globalpay.reader.MerchantPropertyReader;
import com.lianpay.globalpay.utils.ISOUtil;
import com.lianpay.globalpay.utils.LoggerUtil;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class BaseRequestFormatterCheck {
    private final Logger LOGGER = Logger.getLogger(BaseRequestFormatterCheck.class);

    public List<String> checkPayBaseRequest(BaseRequest request, MerchantPropertyReader merchantPropertyReader) {
        List<String> validateErrors = new LinkedList<String>();
        if (ISOUtil.isNullOrEmpty(request.getMerchantTransactionId())
                || !Validator.validateLength(request.getMerchantTransactionId(), 64, 1)) {
            LoggerUtil.error(LOGGER, merchantPropertyReader, "request merchantTransactionId is incorrect");
            validateErrors.add("request merchantTransactionId is incorrect");
        }
        if (ISOUtil.isNullOrEmpty(request.getCountry())
                || !Validator.validateLength(request.getCountry(), 2, 2)
                || !CountryEnum.checkCountry(request.getCountry())) {
            LoggerUtil.error(LOGGER, merchantPropertyReader, "request country is incorrect");
            validateErrors.add("request country is incorrect");
        }
        return validateErrors;
    }

}
