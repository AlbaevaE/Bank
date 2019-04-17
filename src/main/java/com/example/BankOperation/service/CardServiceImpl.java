package com.example.BankOperation.service;

import com.example.BankOperation.model.Card;
import com.example.BankOperation.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;


    @Override
    public Card getCardById(Long id) {
        return this.cardRepository.findById(id).get();
    }

    @Override
    public List<Card> getAllCards() {
        return this.cardRepository.findAll();
    }

    @Override
    public Card addCard(Card c) {
        return this.cardRepository.save(c);
    }

    @Override
    public Card updateCard(Card c) {
        return this.cardRepository.save(c);
    }

    @Override
    public void deleteCard(Long id) {
        this.cardRepository.deleteById(id);

    }
}
