package org.example.testjavaee.dao.interfaces;

import org.example.testjavaee.entities.Payment;

public interface PaymentsDao {
    void add(Payment p);
    Long getBalance();
    Long getSumNalog();
}
