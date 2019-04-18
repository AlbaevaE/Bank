package com.example.BankOperation.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardName;
    private Integer cardNumber;
    private BigDecimal balance;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    public Card() {
    }

    public Card(Long id, String cardName, Integer cardNumber, BigDecimal balance, Client client) {
        this.id = id;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
