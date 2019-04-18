package com.example.BankOperation.model;

import com.example.BankOperation.enums.PaymentStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String target;
    private BigDecimal amount;
    private LocalDateTime time;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "credit_id")
    private Credit credit;
    private PaymentStatus paymentStatus;
    private Integer confirmationCode;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "wallet_id")
//    private Wallet wallet;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id")
    private Card card;


    public Payment() {
    }

    public Payment(String target, BigDecimal amount, LocalDateTime time,
                   Credit credit, Card card) {
        this.target = target;
        this.amount = amount;
        this.time = time;
        this.credit = credit;
        this.card = card;
    }

    public Integer getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(Integer confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
