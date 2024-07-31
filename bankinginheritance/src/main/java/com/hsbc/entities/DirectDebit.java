package com.hsbc.entities;

import com.hsbc.models.Customer;
import com.hsbc.models.Person;
import com.hsbc.models.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DirectDebit extends Transaction {

    private LocalDate paymentDate;

    public DirectDebit() {
    }

    @Override
    public void trackTransaction() {

        if(this.transactionAmount>25000)
            System.out.println("Call the customer and verify the transaction");

    }


    public DirectDebit(long transactionAmount, LocalDateTime timeStamp, Customer sender, Person receiver, LocalDate paymentDate) {
        super(transactionAmount, timeStamp, sender, receiver);
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "DirectDebit{" +
                "paymentDate=" + paymentDate +
                '}';
    }
}
