package org.example.testjavaee.service;

import org.example.testjavaee.dao.implementation.PaymentsDaoImpl;
import org.example.testjavaee.entities.Payment;
import org.example.testjavaee.entities.Result;

public class BankService {
    private PaymentsDaoImpl paymentsDao = new PaymentsDaoImpl();

    public void add(Payment p){
        paymentsDao.add(p);
    }

    public Result result(){
        Long balance = paymentsDao.getBalance();
        Long sumNalog = paymentsDao.getSumNalog();
        float percent = sumNalog.floatValue() / balance * 100;

        Result result = new Result();
        result.setBalance(balance);
        result.setPercent(percent);
        return result;
    }
}
