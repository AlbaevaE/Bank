package com.example.BankOperation.util;

import com.example.BankOperation.model.Card;

import java.io.Serializable;

public class PaymentMethods implements Serializable {
    private Card card;

    public PaymentMethods() {
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
