package com.hsbc.entities;

import com.hsbc.models.Account;

public class CurrentAccount extends Account {

    private long odLimit;

    public CurrentAccount(boolean status) {
        super(status);
    }
}
