package com.hsbc.entities;

import com.hsbc.models.Account;
import com.hsbc.models.Transaction;

public class SavingsAccount extends Account {

    private float roi;
    private boolean status;

    public SavingsAccount(boolean status) {
        super(status);
    }

    public String isStatus() {
        return super.status+"," +this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Sub class overrridden method return type should be
     * super class ooverriden methods return type or
     * its subtype
     *
     *
     * @return
     */

    @Override
    public DirectDebit getTransaction() {
        return new DirectDebit();
    }
}


