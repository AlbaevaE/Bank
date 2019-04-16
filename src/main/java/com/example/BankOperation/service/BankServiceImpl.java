package com.example.BankOperation.service;

import com.example.BankOperation.model.Bank;
import com.example.BankOperation.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankRepository bankRepository;


    @Override
    public Bank addBank(Bank b) {
        return this.bankRepository.save(b);
    }

    @Override
    public List<Bank> getAllBanks() {
        return this.bankRepository.findAll();
    }

    @Override
    public Bank getBankById(Long id) {
        return this.bankRepository.findById(id).get();
    }

    @Override
    public void deleteBankById(Long id) {
        this.bankRepository.deleteById(id);
    }

    @Override
    public Bank updateBank(Bank b) {
        return this.bankRepository.save(b);
    }
}
