package com.hsbc.utility;

import com.hsbc.models.Customer;

public class VarDemo {
    public static void main(String[] args){
        //local or reference variable
        Customer customer=null;
       //null pointer exception
        // System.out.println(customer.getAccountNo());
     //class variable
        Customer.bankName="HSBC";
        System.out.println(Customer.bankName);

    }
}
