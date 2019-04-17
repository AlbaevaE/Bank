package com.example.BankOperation.service;

import com.example.BankOperation.model.Card;

import java.util.List;

public interface CardService {
    Card getCardById(Long id);

    List<Card> getAllCards();

    Card addCard(Card c);

    Card updateCard(Card c);

    void deleteCard(Long id);
}
