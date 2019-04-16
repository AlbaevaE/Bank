package com.example.BankOperation.service;

import com.example.BankOperation.model.Payment;
import com.example.BankOperation.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public Payment addPayment(Payment p) {
        return this.paymentRepository.save(p);
    }

    @Override
    public List<Payment> getAllPayment() {
        return this.paymentRepository.findAll();
    }

    @Override
    public Payment getPayment(Long id) {
        return this.paymentRepository.findById(id).get();
    }

    @Override
    public Payment updatePayment(Payment p) {
        return this.paymentRepository.save(p);
    }

    @Override
    public void deletePayment(Long id) {
        this.paymentRepository.deleteById(id);
    }
}
