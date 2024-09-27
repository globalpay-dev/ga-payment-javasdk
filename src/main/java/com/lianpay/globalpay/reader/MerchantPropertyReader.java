package com.lianpay.globalpay.reader;

import com.lianpay.globalpay.constants.GlobalpayConstants;
import com.lianpay.globalpay.domain.bean.ParamValidateRes;
import com.lianpay.globalpay.enums.AlgorithmEnum;
import com.lianpay.globalpay.utils.ISOUtil;
import com.lianpay.globalpay.utils.LoggerUtil;
import com.lianpay.globalpay.validator.Validator;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class MerchantPropertyReader {
    private static final Logger LOGGER = Logger.getLogger(MerchantPropertyReader.class);
    Properties clientProps = new Properties();
    private String DEBUGGER_FLAG = GlobalpayConstants.STRING_ON;
    private String TEST_MODEL = GlobalpayConstants.STRING_OFF;
    private String MERCHANT_ID;
    private String SUB_MERCHANT_ID;
    private String SIGN_TYPE = AlgorithmEnum.RSA.name();
    private String MERCHANT_SIGN_KEY;
    private String LL_SIGN_KEY;

    private String HK_NET_MODEL= GlobalpayConstants.STRING_OFF;

    public MerchantPropertyReader() {
    }

    public MerchantPropertyReader(String propertyFilePath) {
        URL url = null;
        try {
            url = MerchantPropertyReader.class.getResource(propertyFilePath);
            this.clientProps.load(url.openStream());
            this.init();
        } catch (Exception var12) {
            if (openDebuggerLog()) {
                LOGGER.fatal("Error in setProxyDetailsFile() method..  Exception: " + var12);
            }
        } finally {
            try {
                url.openStream().close();
            } catch (IOException var11) {
                if (openDebuggerLog()) {
                    LOGGER.fatal("Error in finally block of setProxyDetailsFile() method..  IOException: " + var11);
                }
            }
        }
    }

    public void init() {
        setDEBUGGER_FLAG(this.clientProps.getProperty("DEBUGGER_FLAG", GlobalpayConstants.STRING_ON).trim());
        setTEST_MODEL(this.clientProps.getProperty("TEST_MODEL", GlobalpayConstants.STRING_OFF));
        setMERCHANT_ID(this.clientProps.getProperty("MERCHANT_ID", ISOUtil.EMPTY_STRING).trim());
        String subMerchantId = this.clientProps.getProperty("SUB_MERCHANT_ID", ISOUtil.EMPTY_STRING).trim();
        setSUB_MERCHANT_ID(ISOUtil.isNullOrEmpty(subMerchantId) ? null : subMerchantId);
        setSIGN_TYPE(this.clientProps.getProperty("SIGN_TYPE", AlgorithmEnum.RSA.name()).trim());
        setMERCHANT_SIGN_KEY(this.clientProps.getProperty("MERCHANT_SIGN_KEY", ISOUtil.EMPTY_STRING).trim());
        setLL_SIGN_KEY(this.clientProps.getProperty("LL_SIGN_KEY", ISOUtil.EMPTY_STRING).trim());
        setHK_NET_MODEL(this.clientProps.getProperty("HK_NET_MODEL", GlobalpayConstants.STRING_OFF).trim());
    }

    public Boolean openDebuggerLog() {
        return GlobalpayConstants.STRING_ON.equalsIgnoreCase(DEBUGGER_FLAG);
    }

    public Boolean openTestModel() {
        return GlobalpayConstants.STRING_ON.equalsIgnoreCase(TEST_MODEL);
    }

    public Boolean openHKNetModel() {
        return GlobalpayConstants.STRING_ON.equalsIgnoreCase(HK_NET_MODEL);
    }

    public AlgorithmEnum getAlgorithm() {
        return AlgorithmEnum.getByName(SIGN_TYPE);
    }

    public String getDEBUGGER_FLAG() {
        return DEBUGGER_FLAG;
    }

    public void setDEBUGGER_FLAG(String DEBUGGER_FLAG) {
        this.DEBUGGER_FLAG = DEBUGGER_FLAG;
    }

    public String getTEST_MODEL() {
        return TEST_MODEL;
    }

    public void setTEST_MODEL(String TEST_MODEL) {
        this.TEST_MODEL = TEST_MODEL;
    }

    public String getMERCHANT_ID() {
        return MERCHANT_ID;
    }

    public void setMERCHANT_ID(String MERCHANT_ID) {
        this.MERCHANT_ID = MERCHANT_ID;
    }

    public String getSUB_MERCHANT_ID() {
        return SUB_MERCHANT_ID;
    }

    public void setSUB_MERCHANT_ID(String SUB_MERCHANT_ID) {
        this.SUB_MERCHANT_ID = SUB_MERCHANT_ID;
    }

    public String getSIGN_TYPE() {
        return SIGN_TYPE;
    }

    public void setSIGN_TYPE(String SIGN_TYPE) {
        this.SIGN_TYPE = SIGN_TYPE;
    }

    public String getMERCHANT_SIGN_KEY() {
        return MERCHANT_SIGN_KEY;
    }

    public void setMERCHANT_SIGN_KEY(String MERCHANT_SIGN_KEY) {
        this.MERCHANT_SIGN_KEY = MERCHANT_SIGN_KEY;
    }

    public String getLL_SIGN_KEY() {
        return LL_SIGN_KEY;
    }

    public void setLL_SIGN_KEY(String LL_SIGN_KEY) {
        this.LL_SIGN_KEY = LL_SIGN_KEY;
    }

    public String getHK_NET_MODEL() {
        return HK_NET_MODEL;
    }

    public void setHK_NET_MODEL(String HK_NET_MODEL) {
        this.HK_NET_MODEL = HK_NET_MODEL;
    }

    public ParamValidateRes checkPropertyParams() {
        ParamValidateRes paramValidateRes = new ParamValidateRes();
        if (ISOUtil.isNullOrEmpty(MERCHANT_ID)
                || !Validator.validateLength(MERCHANT_ID, 32, 1)) {
            LoggerUtil.error(LOGGER, this, "properties MERCHANT_ID is incorrect");
            paramValidateRes.addValidateError("properties MERCHANT_ID is incorrect");
        }
        if (!ISOUtil.isNullOrEmpty(SUB_MERCHANT_ID)
                && !Validator.validateLength(SUB_MERCHANT_ID, 32, 1)) {
            LoggerUtil.error(LOGGER, this, "properties SUB_MERCHANT_ID is incorrect");
            paramValidateRes.addValidateError("properties SUB_MERCHANT_ID is incorrect");
        }
        if (ISOUtil.isNullOrEmpty(MERCHANT_SIGN_KEY)) {
            LoggerUtil.error(LOGGER, this, "properties MERCHANT_SIGN_KEY is incorrect");
            paramValidateRes.addValidateError("properties MERCHANT_SIGN_KEY is incorrect");
        }
        if (ISOUtil.isNullOrEmpty(LL_SIGN_KEY)) {
            LoggerUtil.error(LOGGER, this, "properties LL_SIGN_KEY is incorrect");
            paramValidateRes.addValidateError("properties LL_SIGN_KEY is incorrect");
        }
        return paramValidateRes;
    }
}
