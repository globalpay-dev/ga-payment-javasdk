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
     * Computes the HMAC-MD5 digest for a given message and secret key.
     *
     * @param msg        The message to be hashed.
     * @param secretKey  The secret key used for hashing.
     * @return           The Base64-encoded HMAC-MD5 digest.
     * @throws UnsupportedEncodingException If the encoding is not supported.
     * @throws NoSuchAlgorithmException If the specified algorithm is not available.
     * @throws InvalidKeyException If the key is invalid.
     */
    public static String hmacMD5Digest(String msg, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return hmacDigest(msg, secretKey, DIGEST_ALGORITHM_HMACMD5);
    }

    /**
     * Computes the HMAC-SHA1 digest for a given message and secret key.
     *
     * @param msg        The message to be hashed.
     * @param secretKey  The secret key used for hashing.
     * @return           The hexadecimal representation of the HMAC-SHA1 digest.
     * @throws UnsupportedEncodingException If the encoding is not supported.
     * @throws NoSuchAlgorithmException If the specified algorithm is not available.
     * @throws InvalidKeyException If the key is invalid.
     */
    public static String hmacSHA1Digest(String msg, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return hmacDigest(msg, secretKey, DIGEST_ALGORITHM_HMACSHA1);
    }

    /**
     * Computes the HMAC-SHA256 digest for a given message and secret key.
     *
     * @param msg        The message to be hashed.
     * @param secretKey  The secret key used for hashing.
     * @return           The hexadecimal representation of the HMAC-SHA256 digest.
     * @throws UnsupportedEncodingException If the encoding is not supported.
     * @throws NoSuchAlgorithmException If the specified algorithm is not available.
     * @throws InvalidKeyException If the key is invalid.
     */
    public static String hmacSHA256Digest(String msg, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return hmacDigest(msg, secretKey, DIGEST_ALGORITHM_HMAC256);
    }

    /**
     * Computes the HMAC-SHA256 digest for a given message and secret key and returns the result as a Base64-encoded string.
     *
     * @param msg        The message to be hashed.
     * @param secretKey  The secret key used for hashing.
     * @return           The Base64-encoded HMAC-SHA256 digest.
     * @throws UnsupportedEncodingException If the encoding is not supported.
     * @throws NoSuchAlgorithmException If the specified algorithm is not available.
     * @throws InvalidKeyException If the key is invalid.
     */
    public static String hmacSHA256DigestWithBase64(String msg, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return hmacDigestWithBase64(msg, secretKey, DIGEST_ALGORITHM_HMAC256);
    }

    /**
     * Computes the HMAC-SHA512 digest for a given message and secret key.
     *
     * @param msg        The message to be hashed.
     * @param secretKey  The secret key used for hashing.
     * @return           The hexadecimal representation of the HMAC-SHA512 digest.
     * @throws UnsupportedEncodingException If the encoding is not supported.
     * @throws NoSuchAlgorithmException If the specified algorithm is not available.
     * @throws InvalidKeyException If the key is invalid.
     */
    public static String hmacSHA512Digest(String msg, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        return hmacDigest(msg, secretKey, DIGEST_ALGORITHM_HMAC512);
    }

    /**
     * Computes the HMAC digest for a given message, secret key, and algorithm.
     *
     * @param msg        The message to be hashed.
     * @param secretKey  The secret key used for hashing.
     * @param algorithm  The name of the HMAC algorithm (e.g., "HMACSHA256").
     * @return           The hexadecimal representation of the HMAC digest.
     * @throws UnsupportedEncodingException If the encoding is not supported.
     * @throws NoSuchAlgorithmException If the specified algorithm is not available.
     * @throws InvalidKeyException If the key is invalid.
     */
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
