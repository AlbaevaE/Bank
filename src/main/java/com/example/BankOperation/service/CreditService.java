package com.example.BankOperation.service;

import com.example.BankOperation.model.Credit;

import java.util.List;


public interface CreditService {
    Credit addCredit(Credit c);

    List<Credit> getAllCredit();

    Credit updateCredit(Credit c);

    Credit getCreditById(Long id);

    void deleteCreditById(Long id);

    List<Credit> getPaidCredits();

    List<Credit> getUnPaidCredits();

    List<Credit> getOutDatedCredits();

}
