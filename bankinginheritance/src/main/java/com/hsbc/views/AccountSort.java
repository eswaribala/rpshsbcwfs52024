package com.hsbc.views;

import com.hsbc.models.Account;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class AccountSort {

    public static void main(String[] args){
        Account[] accounts=new Account[10];
        for(int i=0;i<10;i++){
            accounts[i]=new Account(new Random().nextInt(),
                    LocalDate.of(new Random().nextInt(1970,1999),
                            new Random().nextInt(1,12),
                            new Random().nextInt(1,27)),
                    true);
        }

        Arrays.sort(accounts);

        for(Account account:accounts){
            System.out.println(account);
        }

    }
}
