package com.hsbc.entities;

import com.hsbc.models.Branch;
import com.hsbc.models.Customer;
import com.hsbc.models.Person;
import com.hsbc.models.Transaction;

import java.time.LocalDateTime;

public class ExternalTransaction extends Transaction {

    private Branch branch;

    public ExternalTransaction() {
    }

    @Override
    public void trackTransaction() {

        if(this.transactionAmount>25000){
            System.out.println("Send link to confirm");
        }
    }

    public ExternalTransaction(long transactionAmount, LocalDateTime timeStamp, Customer sender, Person receiver, Branch branch) {
        super(transactionAmount, timeStamp, sender, receiver);
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "ExternalTransaction{" +
                "branch=" + branch +
                '}';
    }
}
