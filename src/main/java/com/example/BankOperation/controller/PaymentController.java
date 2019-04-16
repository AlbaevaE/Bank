package com.example.BankOperation.controller;

import com.example.BankOperation.model.Payment;
import com.example.BankOperation.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    private List<Payment> getAllPayment() {
        return paymentService.getAllPayment();
    }

    @GetMapping("/{id}")
    private Payment getOnePayment(@PathVariable Long id) {
        return paymentService.getPayment(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Payment addPayment(@RequestBody Payment p) {
        return paymentService.addPayment(p);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Payment updatePayment(@RequestBody Payment p) {
        return paymentService.updatePayment(p);
    }

    @DeleteMapping("/{id}")
    private void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
