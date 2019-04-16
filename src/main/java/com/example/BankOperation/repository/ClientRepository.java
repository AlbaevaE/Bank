package com.example.BankOperation.repository;

import com.example.BankOperation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select sum(c.amount) from Credit " +
            "c inner join c.client cl where cl.id = :client_id")
    BigDecimal getSumCredit(@Param("client_id") Long client_id);
}
