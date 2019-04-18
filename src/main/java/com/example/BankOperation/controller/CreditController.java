package com.example.BankOperation.controller;

import com.example.BankOperation.model.Credit;
import com.example.BankOperation.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/credit")
public class CreditController {
    @Autowired
    private CreditService creditService;

    @GetMapping
    private List<Credit> getAllCredits() {
        return creditService.getAllCredit();
    }

    @GetMapping("/{id}")
    private Credit getCredit(@PathVariable Long id) {
        return creditService.getCreditById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Credit addCredit(@RequestBody Credit c) {
        return creditService.addCredit(c);
    }

    @DeleteMapping("/{id}")
    private void deleteCredit(@PathVariable Long id) {
        creditService.deleteCreditById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Credit updateCredit(@RequestBody Credit c) {
        return creditService.updateCredit(c);
    }

    @GetMapping("/unPaidCredits")
    public List<Credit> getUnPaidCredits() {
        return this.creditService.getUnPaidCredits();
    }
    @GetMapping("/paidCredits")
    public List<Credit> getPaidCredits(){
        return this.creditService.getPaidCredits();
    }

    @GetMapping("/outDatedCredits")
    public List<Credit> getOutDatedCredits() {
        return this.creditService.getOutDatedCredits();
    }

}
