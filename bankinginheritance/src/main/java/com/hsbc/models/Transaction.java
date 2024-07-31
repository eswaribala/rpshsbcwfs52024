package com.hsbc.models;

import java.time.LocalDateTime;

abstract public class Transaction {
    protected long transactionAmount;
    protected LocalDateTime timeStamp;
    protected Customer sender;
    protected Person receiver;

    public Transaction() {
    }

    public Transaction(long transactionAmount, LocalDateTime timeStamp, Customer sender, Person receiver) {
        this.transactionAmount = transactionAmount;
        this.timeStamp = timeStamp;
        this.sender = sender;
        this.receiver = receiver;
    }

    //make call to confirm transaction if it is above Rs.25000
    public abstract void trackTransaction();


    @Override
    public String toString() {
        return "Transaction{" +
                "transactionAmount=" + transactionAmount +
                ", timeStamp=" + timeStamp +
                ", sender=" + sender +
                ", receiver=" + receiver +
                '}';
    }
}
