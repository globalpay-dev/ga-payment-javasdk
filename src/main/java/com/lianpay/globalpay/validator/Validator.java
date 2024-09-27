package com.lianpay.globalpay.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    protected static Validator objValidator;

    public Validator() {
    }

    public static Validator getSingleton() {
        if (objValidator == null) {
            getInstance();
        }

        return objValidator;
    }

    private static synchronized Validator getInstance() {
        if (objValidator == null) {
            try {
                objValidator = new Validator();
            } catch (Exception var1) {
                return null;
            }
        }

        return objValidator;
    }

    public static boolean validateValue(String value, int bitNumber, int maxLength, int minLength, boolean validateLength, boolean validateData, String regEx) {
        boolean flag = true;
        if (validateLength) {
            flag = validateLength(value, maxLength, minLength);
            if (!flag) {
                return flag;
            }
        }
        if (validateData) {
            flag = validateData(value, regEx);
        }
        return flag;
    }

    public static boolean validateLength(String value, int maxLength, int minLength) {
        return value.length() <= maxLength && value.length() >= minLength;
    }

    private static boolean validateData(String value, String expression) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

}
