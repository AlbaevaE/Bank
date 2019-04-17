package com.example.BankOperation.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String creditName;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private LocalDateTime time;
    private boolean isPaid;

    public Credit() {
    }

    public Credit(Long id, String creditName, BigDecimal amount, Client client, LocalDateTime time) {
        this.id = id;
        this.creditName = creditName;
        this.amount = amount;
        this.client = client;
        this.time = LocalDateTime.now();
    }

    public Credit(BigDecimal amount, Client client) {
        this.amount = amount;
        this.client = client;
        this.time = LocalDateTime.now();
        if (amount.remainder(BigDecimal.valueOf(2)).equals(BigDecimal.ZERO)) {
            this.creditName = "Ok";
        } else {
            this.creditName = "Error";
        }
    }

    public Credit(Long id, String creditName, BigDecimal amount, Client client, LocalDateTime time, boolean isPaid) {
        this.id = id;
        this.creditName = creditName;
        this.amount = amount;
        this.client = client;
        this.time = time;
        this.isPaid = isPaid;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }


}
