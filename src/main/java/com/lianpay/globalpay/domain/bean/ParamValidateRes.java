package com.lianpay.globalpay.domain.bean;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ParamValidateRes implements Serializable {
    private static final long serialVersionUID = -3007353861344706999L;
    private final List<String> validateErrorList = new LinkedList<String>();

    public List<String> getValidateErrorList() {
        return validateErrorList;
    }

    public void addValidateError(String validateError) {
        validateErrorList.add(validateError);
    }

    public void addValidateErrors(List<String> validateErrors) {
        validateErrorList.addAll(validateErrors);
    }
}
