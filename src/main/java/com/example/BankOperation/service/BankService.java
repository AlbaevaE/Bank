package com.example.BankOperation.service;

import com.example.BankOperation.model.Bank;

import java.util.List;

public interface BankService {
    Bank addBank(Bank b);

    List<Bank> getAllBanks();

    Bank getBankById(Long id);

    void deleteBankById(Long id);

    Bank updateBank(Bank b);
}
