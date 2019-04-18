package com.example.BankOperation.enums;

import com.example.BankOperation.util.PaymentErrorCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

public enum RequestPaymentError implements PaymentErrorCode {

    NOT_ENOUGH_FUNDS("not_enough_funds"),

    LIMIT_EXCEEDED("limit_exceeded"),

    ACCOUNT_BLOCKED("account_blocked"),

    AUTHORIZATION_REJECT("authorization_reject"),//В авторизации платежа отказано

    PHONE_UNKNOWN("phone_unknown"),

    TECHNICAL_ERROR("technical_error");

    private final String code;

    private static final Log LOG = LogFactory.getLog(RequestPaymentError.class);

    private static Map<String,RequestPaymentError> map;

    static {
        map = new HashMap<String, RequestPaymentError>();
        for (RequestPaymentError error : values()) {
            map.put(error.code, error);
        }
    }

    public static RequestPaymentError getByCode(String code) {
        if (code == null) {
            return null;
        }

        RequestPaymentError error = map.get(code);
        if (error != null) {
            return error;
        }

        LOG.error("unknown error code: " + code);
        return TECHNICAL_ERROR;
    }

    RequestPaymentError(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
