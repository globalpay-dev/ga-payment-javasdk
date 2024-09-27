package com.lianpay.globalpay.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lianpay.globalpay.domain.ImmutablePair;
import com.lianpay.globalpay.enums.AlgorithmEnum;
import com.lianpay.globalpay.exception.SignException;
import com.lianpay.globalpay.exception.VerifySignFailException;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SignUtil {
    private static final Logger LOGGER = Logger.getLogger(SignUtil.class);
    private SignUtil() {}

    public static String generateSignatureString(Map<String, Object> payment, Boolean noPadding) throws Exception {
        StringBuffer content = new StringBuffer();
        append(content, payment, noPadding);
        return content.toString();
    }

    private static void append(StringBuffer content, Map<String, Object> sourceObj, Boolean noPadding) throws Exception {
        if (sourceObj == null) {
            return;
        }
        Map<String, Object> obj = sourceObj;
        if (obj.keySet().size() == 0) {
            return;
        }
        List<String> keyList = new ArrayList<String>(obj.keySet().size());
        for (String key : obj.keySet()) {
            keyList.add(key);
        }
        Collections.sort(keyList);
        for (String key : keyList) {
            Object value = obj.get(key);
            if (value instanceof List) {
                for (int i = 0; i < ((List<?>) value).size(); i++) {
                    Object item = ((List<?>) value).get(i);
                    if (item instanceof Map){
                        append(content, (Map<String, Object>)item, noPadding);
                    }
                }
            } else if (value instanceof Map) {
                append(content, (Map<String, Object>)value, noPadding);
            } else if (value instanceof String
                    || value instanceof Float
                    || value instanceof Double
                    || value instanceof Integer
                    || value instanceof Long
                    || value instanceof BigDecimal
                    || value instanceof Boolean) {
                if(content.length() > 0 && !noPadding){
                    content.append("&");
                }
                content.append(key);
                if (!noPadding) {
                    content.append("=");
                }
                content.append(value);
            }
        }
    }

    public static void checkSign(String sign, Map<String, Object> payment, String publicKey, AlgorithmEnum algorithm) throws VerifySignFailException {
        try {
            Boolean noPadding = AlgorithmEnum.HMAC.equals(algorithm);
            String signContent = SignUtil.generateSignatureString(payment, noPadding);
            boolean checkSign;
            if (AlgorithmEnum.RSA.equals(algorithm)) {
                checkSign = TraderRSAUtil.checkSign(publicKey, signContent, sign);
            } else {
                checkSign = DigestUtil.hmacSHA256Digest(signContent, publicKey).equals(sign);
            }
            if (!checkSign) {
                throw new Exception("check sign fail");
            }
        } catch (Exception e) {
            throw new VerifySignFailException(e.getMessage(), e);
        }
    }

    public static void checkSign(String sign, String jsonString, String rsaPublic, AlgorithmEnum algorithm) throws VerifySignFailException {
        Map<String, Object> map = JacksonUtils.parseObject(jsonString, new TypeReference<Map<String, Object>>(){});
        checkSign(sign, map, rsaPublic, algorithm);
    }

    public static String addJsonStringSign(String jsonString, String privateKey, AlgorithmEnum algorithm, boolean openLog) throws SignException {
        try {
            Map<String, Object> map = JacksonUtils.parseObject(jsonString, new TypeReference<Map<String, Object>>(){});
            return addSign(map, privateKey, algorithm, openLog);
        } catch (Exception e) {
            throw new SignException(e.getMessage(), e);
        }
    }

    public static String addMapSign(Map<String, Object> param, String privateKey, AlgorithmEnum algorithm, boolean openLog) throws SignException {
        try {
            return addSign(param, privateKey, algorithm, openLog);
        } catch (Exception e) {
            throw new SignException(e.getMessage(), e);
        }
    }

    private static String addSign(Map<String, Object> payment, String privateKey, AlgorithmEnum algorithm, boolean openLog) throws Exception{
        Boolean noPadding = AlgorithmEnum.HMAC.equals(algorithm);
        String signContent = SignUtil.generateSignatureString(payment, noPadding);
        LoggerUtil.info(LOGGER, openLog, "sign algorithm:[" + algorithm.getSignAlg() + "], origin string:[" + signContent + "]");
        if (AlgorithmEnum.RSA.equals(algorithm)) {
            return TraderRSAUtil.sign(privateKey, signContent, algorithm.getSignAlg());
        }
        return DigestUtil.hmacSHA256Digest(signContent, privateKey);
    }


    public static ImmutablePair</*publicKey*/String, /*privateKey*/String> initRsaKey() throws Exception {
        //获得对象 KeyPairGenerator
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        //通过对象 KeyPairGenerator 获取对象KeyPair
        KeyPair keyPair = keyPairGen.generateKeyPair();

        //通过对象 KeyPair 获取RSA公私钥对象RSAPublicKey RSAPrivateKey
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        String publicKeyStr = Base64.encodeBase64String(publicKey.getEncoded());
        publicKeyStr = publicKeyStr.replaceAll("\n", "");
        publicKeyStr = publicKeyStr.replaceAll("\r", "");
        String privateKeyStr = Base64.encodeBase64String(privateKey.getEncoded());
        privateKeyStr = privateKeyStr.replaceAll("\r", "");
        privateKeyStr = privateKeyStr.replaceAll("\n", "");
        return ImmutablePair.of(publicKeyStr, privateKeyStr);
    }


}
