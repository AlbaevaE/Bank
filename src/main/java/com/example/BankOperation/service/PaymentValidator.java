package com.example.BankOperation.service;

import com.example.BankOperation.model.Card;
import com.example.BankOperation.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class PaymentValidator implements org.springframework.validation.Validator {
    @Autowired
    private Validator validator;

    @Override
    public boolean supports(Class<?> aClass) {
        return Card.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Set<ConstraintViolation<Object>> validates = validator.validate(obj);

        for (ConstraintViolation<Object> constraintViolation : validates) {
            String propertyPath = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            errors.rejectValue(propertyPath, "", message);
        }

        Card c = (Payment) obj;
        if (c.getBalance() < 0) {
            errors.rejectValue("balance - ", "only '+'balance");
        }
    }

}

