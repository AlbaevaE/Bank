package com.example.BankOperation.service;

import com.example.BankOperation.model.Client;
import com.example.BankOperation.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;


    @Override
    public Client addClient(Client cl) {
        return this.clientRepository.save(cl);
    }

    @Override
    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return this.clientRepository.findById(id).get();
    }

    @Override
    public Client updateClient(Client cl) {
        return this.clientRepository.save(cl);
    }

    @Override
    public void deleteClientById(Long id) {
      this.clientRepository.deleteById(id);
    }

    @Override
    public Client changeIsActive(Client cl) {
        if (cl.isActive()) {
            cl.setActive(false);
            clientRepository.save(cl);
        }
        return cl;
    }

    @Override
    public BigDecimal getSumCredit(Long id) {
        return clientRepository.getSumCredit(id);
    }
}
