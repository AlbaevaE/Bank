package com.example.BankOperation.service;

import com.example.BankOperation.model.Credit;
import com.example.BankOperation.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditServiceImpl implements CreditService {
    @Autowired
    private CreditRepository creditRepository;


    @Override
    public Credit addCredit(Credit c) {
        return this.creditRepository.save(c);
    }

    @Override
    public List<Credit> getAllCredit() {
        return this.creditRepository.findAll();
    }

    @Override
    public Credit updateCredit(Credit c) {
        return this.creditRepository.save(c);
    }

    @Override
    public Credit getCreditById(Long id) {
        return this.creditRepository.findById(id).get();
    }

    @Override
    public void deleteCreditById(Long id) {
        this.creditRepository.deleteById(id);

    }
    @Override
    public List<Credit> getPaidCredits() {
        return creditRepository.findAll().stream().filter(x->x.isPaid()).collect(Collectors.toList());
    }

    @Override
    public List<Credit> getUnPaidCredits() {
        return creditRepository.findAll().stream().filter(x->!x.isPaid()).collect(Collectors.toList());
    }
    @Override
    public List<Credit> getOutDatedCredits() {
        return null;
    }
}
