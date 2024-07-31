package com.hsbc.views;

import com.hsbc.entities.DirectDebit;
import com.hsbc.entities.ExternalTransaction;
import com.hsbc.models.Transaction;

public class AbstractDemo {

    public static  void main(String[] args){
        //abstract class cannot be instantiated
        //Transaction transaction=new Transaction();
        //abstract class can have anonymous object
        Transaction transaction=new Transaction() {
            @Override
            public void trackTransaction() {

            }
        };

        Transaction transactionObj=new DirectDebit();
        Transaction transactionObj1=new ExternalTransaction();


    }
}
