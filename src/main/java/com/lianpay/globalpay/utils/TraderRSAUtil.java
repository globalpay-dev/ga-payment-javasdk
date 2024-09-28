package com.lianpay.globalpay.utils;

import com.lianpay.globalpay.enums.AlgorithmEnum;
import com.lianpay.globalpay.exception.SignException;
import com.lianpay.globalpay.exception.VerifySignFailException;
import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Map;

public final class TraderRSAUtil {


    private static TraderRSAUtil instance;

    private TraderRSAUtil() {

    }

    public static TraderRSAUtil getInstance() {
        if (null == instance) {
            return new TraderRSAUtil();
        }
        return instance;
    }

    /**
     * Generates a digital signature using the provided private key and content.
     *
     * @param prikeyvalue The private key used for signing.
     * @param sign_str    The content to be signed.
     * @return            The base64-encoded digital signature.
     * @throws SignException If the signature generation fails.
     */
    public static String sign(String prikeyvalue, String sign_str) throws SignException {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                    Base64.decodeBase64(prikeyvalue.getBytes("UTF-8")));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey myprikey = keyf.generatePrivate(priPKCS8);
            // 用私钥对信息生成数字签名
            java.security.Signature signet = java.security.Signature.getInstance(AlgorithmEnum.RSA.getSignAlg());
            signet.initSign(myprikey);
            signet.update(sign_str.getBytes("UTF-8"));
            byte[] signed = signet.sign(); // 对信息的数字签名
            return new String(Base64.encodeBase64(signed));
        } catch (Exception e) {
            throw new SignException(e.getMessage(), e);
        }
    }

    public static String signObject(String privateKey, Map<String, Object> srcMap) throws SignException {
        return signObject(privateKey, srcMap, AlgorithmEnum.RSA.getSignAlg());
    }

    public static String signObject(String privateKey, Map<String, Object> srcMap, String signAlg) throws SignException {
        return sign(privateKey, composeSrcObject(srcMap), signAlg);
    }

    public static String sign(String privateKey, Map<String, String> srcMap) throws SignException {
        return sign(privateKey, srcMap, AlgorithmEnum.RSA.getSignAlg());
    }

    public static String sign(String privateKey, Map<String, String> srcMap, String signAlg) throws SignException {
        return sign(privateKey, composeSrc(srcMap), signAlg);
    }

    public static String composeSrc(Map<String, String> srcMap) {
        Object[] keys = srcMap.keySet().toArray();
        Arrays.sort(keys);
        StringBuilder src = new StringBuilder();
        for (Object key : keys) {
            String k = (String) key;
            String value = srcMap.get(k);
            if (ISOUtil.isNullOrEmpty(value)) {
                src.append("&").append(k).append("=").append(srcMap.get(k));
            }
        }
        String signText = ISOUtil.isNullOrEmpty(src.toString()) ? "" : src.substring(1);
        return signText;
    }
    
    public static String composeSrcObject(Map<String, Object> srcMap) {
        Object[] keys = srcMap.keySet().toArray();
        Arrays.sort(keys);
        StringBuilder src = new StringBuilder();
        for (Object key : keys) {
            String k = (String) key;
            Object value = srcMap.get(k);
            if (value != null) {
                src.append("&").append(k).append("=").append(String.valueOf(value));
            }
        }
        String signText = ISOUtil.isNullOrEmpty(src.toString()) ? "" : src.substring(1);
        return signText;
    }

    public static String sign(String privateKey, String src, String signAlg) throws SignException {
        return sign(privateKey, src);
    }

    /**
     * Verifies the signature using the provided public key, content, and signature string.
     *
     * @param pubkeyvalue The public key used for verification.
     * @param oid_str     The content to be verified.
     * @param signed_str  The signature string to be checked.
     * @return            True if the signature is valid, false otherwise.
     * @throws VerifySignFailException If the signature verification fails.
     */
    public static boolean checksign(String pubkeyvalue, String oid_str,
                                    String signed_str) throws VerifySignFailException {
        try {
            X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(
                    Base64.decodeBase64(pubkeyvalue.getBytes("UTF-8")));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(bobPubKeySpec);
            byte[] signed = Base64.decodeBase64(signed_str.getBytes("UTF-8"));
            java.security.Signature signetcheck = java.security.Signature.getInstance(AlgorithmEnum.RSA.getSignAlg());
            signetcheck.initVerify(pubKey);
            signetcheck.update(oid_str.getBytes("UTF-8"));
            return signetcheck.verify(signed);
        } catch (Exception e) {
            throw new VerifySignFailException(e.getMessage(), e);
        }
    }

    public static boolean checkSignObject(String publicKey, Map<String, Object> srcMap, String signedText) throws VerifySignFailException {
        return checkSign(publicKey, composeSrcObject(srcMap), signedText);
    }

    public static boolean checkSign(String publicKey, Map<String, String> srcMap, String signedText) throws VerifySignFailException {
        return checkSign(publicKey, composeSrc(srcMap), signedText);
    }

    public static boolean checkSign(String publicKey, String src, String signedText) throws VerifySignFailException {
        return checksign(publicKey, src, signedText);
    }

}
