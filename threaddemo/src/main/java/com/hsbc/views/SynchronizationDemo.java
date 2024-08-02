package com.hsbc.views;

import com.hsbc.models.Account;
import com.hsbc.models.AccountThread;

public class SynchronizationDemo {

    public static void main(String[] args){
        Account account=new Account(1000);
        AccountThread soham=new AccountThread(account,"Soham-Thread",1700);
        AccountThread ruthuj=new AccountThread(account,"Ruthuj-Thread",450);
        AccountThread ajay=new AccountThread(account,"Ajay-Thread",300);
        AccountThread pavan=new AccountThread(account,"Pavan-Thread",250);
    }
}
