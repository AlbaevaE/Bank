package com.example.BankOperation.repository;

import com.example.BankOperation.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Long> {
}
