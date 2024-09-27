package com.lianpay.globalpay.utils;

import com.lianpay.globalpay.exception.VerifySignFailException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DigestUtil {

    private final static String DIGEST_ALGORITHM_HMACMD5 = "HmacMD5";

    private final static String DIGEST_ALGORITHM_HMACSHA1 = "HmacSHA1";

    private final static String DIGEST_ALGORITHM_HMAC256 = "HmacSHA256";

    private final static String DIGEST_ALGORITHM_HMAC512 = "HmacSHA512";


    /**
     * HMAC-MD5 摘要算法
     * @param msg
     * @param secretKey
     * @return
     */
    public static String hmacMD5Digest(String msg, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return hmacDigest(msg, secretKey, DIGEST_ALGORITHM_HMACMD5);
    }

    /**
     * HMAC-SHA1 摘要算法
     * @param msg
     * @param secretKey
     * @return
     */
    public static String hmacSHA1Digest(String msg, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return hmacDigest(msg, secretKey, DIGEST_ALGORITHM_HMACSHA1);
    }

    /**
     * HMAC-SHA256 摘要算法
     * @param msg
     * @param secretKey
     * @return
     */
    public static String hmacSHA256Digest(String msg, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return hmacDigest(msg, secretKey, DIGEST_ALGORITHM_HMAC256);
    }

    /**
     * HMAC-SHA256 摘要算法
     * @param msg
     * @param secretKey
     * @return base64编码
     */
    public static String hmacSHA256DigestWithBase64(String msg, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return hmacDigestWithBase64(msg, secretKey, DIGEST_ALGORITHM_HMAC256);
    }

    /**
     * HMAC-SHA512 摘要算法
     * @param msg
     * @param secretKey
     * @return
     */
    public static String hmacSHA512Digest(String msg, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return hmacDigest(msg, secretKey, DIGEST_ALGORITHM_HMAC512);
    }

    private static String hmacDigest(String msg, String secretKey, String algorithm) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((secretKey).getBytes("UTF-8"), algorithm);
            Mac mac = Mac.getInstance(algorithm);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes("UTF-8"));

            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        } catch (UnsupportedEncodingException e) {
            throw e;
        } catch (InvalidKeyException e) {
            throw e;
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
        return digest;
    }

    private static String hmacDigestWithBase64(String msg, String secretKey, String algorithm) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((secretKey).getBytes("UTF-8"), algorithm);
            Mac mac = Mac.getInstance(algorithm);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes("UTF-8"));

            digest = Base64.encodeBase64String(bytes);
        } catch (UnsupportedEncodingException e) {
            throw e;
        } catch (InvalidKeyException e) {
            throw e;
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
        return digest;
    }
}
