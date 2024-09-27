package com.lianpay.globalpay.exception;

import java.util.LinkedList;
import java.util.List;

public class ParamCheckFailException extends BaseException {
    private static final long serialVersionUID = -3634490887977489159L;

    private final List<String> validateErrorList;

    public ParamCheckFailException() {
        validateErrorList = new LinkedList<String>();
    }

    public ParamCheckFailException(List<String> validateErrorList) {
        super("params check fail", "params check fail");
        this.validateErrorList = validateErrorList;
    }

    public List<String> getValidateErrorList() {
        return validateErrorList;
    }
}
