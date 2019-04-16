package com.example.BankOperation.controller;

import com.example.BankOperation.model.Bank;
import com.example.BankOperation.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bank")
public class BankController {
    @Autowired
    private BankService bankService;

    @GetMapping
    private List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }

    @GetMapping("/{id}")
    private Bank getBank(@PathVariable Long id) {
        return bankService.getBankById(id);
    }

    @DeleteMapping("/{id}")
    private void deleteBank(@PathVariable Long id) {
        bankService.deleteBankById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Bank addBank(@RequestBody Bank b) {
        return bankService.addBank(b);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Bank updateBank(@RequestBody Bank b) {
        return bankService.updateBank(b);
    }
}
