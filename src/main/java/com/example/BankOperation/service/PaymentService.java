package com.example.BankOperation.service;

import com.example.BankOperation.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment addPayment(Payment p);

    List<Payment> getAllPayment();

    Payment getPayment(Long id);

    Payment updatePayment(Payment p);

    void deletePayment(Long id);

}
