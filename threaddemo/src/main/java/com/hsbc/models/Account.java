package com.hsbc.models;

public class Account {
    private long balance;

    public Account(int amount){
      //initial balance
        this.balance=amount;
    }

    public void withdraw(long amount) throws InterruptedException {
        if(amount<balance){
            Thread.sleep(1000);
            System.out.println("Withdrawal Permitted...");
            balance=balance-amount;
            System.out.println("Balance After withdraw..."+balance);
            System.out.println("Amount withdrawn..."+amount);
        }else {
            System.out.println("No Sufficient Balance..."+balance);
        }

    }

}
