package com.example.BankOperation.repository;

import com.example.BankOperation.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
