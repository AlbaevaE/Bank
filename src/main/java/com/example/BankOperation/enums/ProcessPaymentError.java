package com.example.BankOperation.enums;

import com.example.BankOperation.util.PaymentErrorCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

public enum ProcessPaymentError implements PaymentErrorCode {

    NOT_ENOUGH_FUNDS(RequestPaymentError.NOT_ENOUGH_FUNDS.getCode()),//Недостаточно средств на счете/привязанной карте

    AUTHORIZATION_REJECT("authorization_reject"),//В проведении платежа отказано

    LIMIT_EXCEEDED(RequestPaymentError.LIMIT_EXCEEDED.getCode()),//Превышен лимит платежей

    ILLEGAL_PARAM_CSC("illegal_param_csc"),//Некорректный формат защитного кода карты


    TECHNICAL_ERROR(RequestPaymentError.TECHNICAL_ERROR.getCode());

    private final String code;

    private static final Log LOG = LogFactory.getLog(ProcessPaymentError.class);

    private static Map<String, ProcessPaymentError> map;

    static {
        map = new HashMap<String, ProcessPaymentError>();
        for (ProcessPaymentError error : values()) {
            map.put(error.code, error);
        }
    }

    public static ProcessPaymentError getByCode(String code) {
        if (code == null) {
            return null;
        }

        ProcessPaymentError error = map.get(code);
        if (error != null) {
            return error;
        }

        LOG.error("unknown error code: " + code);
        return TECHNICAL_ERROR;
    }

    ProcessPaymentError(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
