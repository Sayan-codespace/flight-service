package com.flightService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightService.model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
