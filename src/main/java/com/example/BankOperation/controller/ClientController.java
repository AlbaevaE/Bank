package com.example.BankOperation.controller;

import com.example.BankOperation.model.Client;
import com.example.BankOperation.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    private List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    private Client getClient(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/{id}/sum")
    private BigDecimal getSum(@PathVariable Long id) {
        return clientService.getSumCredit(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Client addClient(@RequestBody Client cl) {
        return clientService.addClient(cl);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Client changeClient(@RequestBody Client cl) {
        return clientService.changeIsActive(cl);
    }

    @DeleteMapping("/{id}")
    private void deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
    }
}
