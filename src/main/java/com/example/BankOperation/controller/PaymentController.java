package com.example.BankOperation.controller;

import com.example.BankOperation.model.Credit;
import com.example.BankOperation.model.Payment;
import com.example.BankOperation.service.CardService;
import com.example.BankOperation.service.CreditService;
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
    @Autowired
    private CreditService creditService;
    @Autowired
    private CardService cardService;

    @PostMapping("/credit/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Payment beginPayment(@PathVariable Long id, @RequestBody Payment payment) {
        payment.setCredit(creditService.getCreditById(id));
        return this.paymentService.beginPayment(payment);
    }

    @PutMapping("/confirmPayment/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Payment confirmPayment(@PathVariable Long id, @RequestBody Confirmation confirmation) {
        return paymentService.confirmPayment(id, confirmation.confirmationCode);
    }

    @GetMapping("/{id}")
    private List<Payment> getAllPayment(@PathVariable Long id) {
        return this.paymentService.getAllPayment(id);
    }

//    @GetMapping("/{id}")
//    private Payment getOnePayment(@PathVariable Long id) {
//        return paymentService.getPayment(id);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    private Credit addPayment(@RequestBody Payment p) {
//        return paymentService.addPayment(p);
//    }
//
//    @PutMapping
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    private Payment updatePayment(@RequestBody Payment p) {
//        return paymentService.updatePayment(p);
//    }
//
//    @DeleteMapping("/{id}")
//    private void deletePayment(@PathVariable Long id) {
//        paymentService.deletePayment(id);
//    }
}

class Confirmation {
    Long paymentId;
    Integer confirmationCode;

    public Confirmation() {

    }

    public Confirmation(Long paymentId, Integer confirmationCode) {
        this.paymentId = paymentId;
        this.confirmationCode = confirmationCode;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(Integer confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
}
