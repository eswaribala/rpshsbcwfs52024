package com.hsbc.models;

import com.hsbc.entities.DirectDebit;
import com.hsbc.entities.ExternalTransaction;

import java.time.LocalDate;

public class Account implements Comparable<Account> {

    protected long runningTotal;
    protected LocalDate openingDate;
    protected boolean status;

    public Account(long runningTotal, LocalDate openingDate, boolean status) {
        this.runningTotal = runningTotal;
        this.openingDate = openingDate;
        this.status = status;
    }

    public final int estbdYear=1950;

    public Account(boolean status) {
        System.out.println("Entering Constructor");
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());


        this.status = status;
    }

    public Transaction getTransaction(){


        return new DirectDebit();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Entering Finalize");
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        //call the gc
        Runtime.getRuntime().gc();

        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
    }

    @Override
    public int compareTo(Account o) {
        return this.openingDate.compareTo(o.openingDate);
    }

    @Override
    public String toString() {
        return "Account{" +
                "runningTotal=" + runningTotal +
                ", openingDate=" + openingDate +
                ", status=" + status +
                ", estbdYear=" + estbdYear +
                '}';
    }
}
