package com.example.BankOperation.service;

import com.example.BankOperation.model.Wallet;

import java.util.List;

public interface WalletService {
    Wallet addWallet(Wallet w);

    List<Wallet> getAllWallet();

    Wallet getWalletById(Long id);

    Wallet update(Wallet w);

    void deleteWallet(Long id);
}
