package com.example.BankOperation.bootstrap;

import com.example.BankOperation.model.Bank;
import com.example.BankOperation.model.Client;
import com.example.BankOperation.model.Credit;
import com.example.BankOperation.model.Payment;
import com.example.BankOperation.service.BankService;
import com.example.BankOperation.service.ClientService;
import com.example.BankOperation.service.CreditService;
import com.example.BankOperation.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private ClientService clientService;

    @Autowired
    private CreditService creditService;

    @Autowired
    private BankService bankService;
    @Autowired
    private PaymentService paymentService;

    @Override
    public void run(String... args) throws Exception {
        Client cl1 = new Client();
        cl1.setName("Master");
        cl1.setActive(false);
        cl1.setPhoneNumber("72342");
        clientService.addClient(cl1);

        Credit cr = new Credit();
        cr.setCreditName("consumer loan");
        cr.setAmount(BigDecimal.TEN);
        cr.setClient(cl1);
        creditService.addCredit(cr);

//        Bank b = new Bank();
//        b.setBankName("CAB");
//        b.setClient(cl1);
//        b.setCredit(cr);
//        bankService.addBank(b);

        Payment p = new Payment();
        p.setCredit(cr);
        p.setTarget("For Study");
        p.setAmount(BigDecimal.valueOf(200));

    }
}
