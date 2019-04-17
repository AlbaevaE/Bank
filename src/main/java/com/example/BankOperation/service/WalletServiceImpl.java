package com.example.BankOperation.service;

import com.example.BankOperation.model.Wallet;
import com.example.BankOperation.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletRepository walletRepository;


    @Override
    public Wallet addWallet(Wallet w) {
        return this.walletRepository.save(w);
    }

    @Override
    public List<Wallet> getAllWallet() {
        return this.walletRepository.findAll();
    }

    @Override
    public Wallet getWalletById(Long id) {
        return this.walletRepository.findById(id).get();
    }

    @Override
    public Wallet update(Wallet w) {
        return this.walletRepository.save(w);
    }

    @Override
    public void deleteWallet(Long id) {
        this.walletRepository.deleteById(id);
    }
}
