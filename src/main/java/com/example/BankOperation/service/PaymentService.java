package com.example.BankOperation.service;

import com.example.BankOperation.model.Credit;
import com.example.BankOperation.model.Payment;

import java.util.List;

public interface PaymentService {
    Credit addPayment(Payment p);

    List<Payment> getAllPayment(Long id);

    Payment getPayment(Long id);

    Payment updatePayment(Payment p);

    void deletePayment(Long id);

    Payment beginPayment(Payment payment);


    Payment confirmPayment(Long id, Integer confirmationCode);
}
