package com.example.BankOperation.service;

import com.example.BankOperation.enums.PaymentStatus;
import com.example.BankOperation.model.Credit;
import com.example.BankOperation.model.Payment;
import com.example.BankOperation.repository.CreditRepository;
import com.example.BankOperation.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CreditRepository creditRepository;


    @Override
    public Credit addPayment(Payment p) {
        BigDecimal oldAmount = p.getCredit().getAmount();
        p.setPaymentStatus(PaymentStatus.inProgress);

        if (oldAmount.compareTo(p.getAmount()) > 0) {
            p.getCredit().setAmount(oldAmount.subtract(p.getAmount()));
            p.setTime(LocalDateTime.now());
            paymentRepository.save(p);
            if (p.getCredit().getAmount().compareTo(BigDecimal.ZERO) == 0) {
                p.getCredit().setPaid(true);
            }
        } else {
            System.out.println("You're trying to pay more than you have to!!!!");
            throw new IllegalArgumentException("Entered payment is greater than the actual amount of the credit needed to be paid!!!!");
        }
        return creditRepository.save(p.getCredit());
    }


    @Override
    public List<Payment> getAllPayment(Long id) {
        List<Payment> payments = paymentRepository.findAll()
                .stream()
                .filter(
                        x -> x.getCredit().getId().equals(id)
                ).collect(Collectors.toList());

        return payments;
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

    @Override
    public Payment beginPayment(Payment payment) {
        return null;
    }

    @Override
    public Payment confirmPayment(Long id, Integer confirmationCode) {
        return null;
    }
}
