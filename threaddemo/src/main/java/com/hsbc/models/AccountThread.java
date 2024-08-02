package com.hsbc.models;

public class AccountThread implements Runnable{
    private Account account;
    private String name;
    private long amount;

    public AccountThread(Account account, String name,long amount) {
        this.account = account;
        this.name = name;
        this.amount=amount;
        new Thread(this,name).start();
    }

    @Override
    public void run() {
        try {
            //critical section
           synchronized (this.account) {
               this.account.withdraw(amount);
           }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
