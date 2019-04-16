package com.example.BankOperation.service;

import com.example.BankOperation.model.Client;

import java.math.BigDecimal;
import java.util.List;

public interface ClientService {
    Client addClient(Client cl);

    List<Client> getAllClients();

    Client getClientById(Long id);

    Client updateClient(Client cl);

    void deleteClientById(Long id);

    Client changeIsActive(Client cl);

    BigDecimal getSumCredit(Long id);
}
