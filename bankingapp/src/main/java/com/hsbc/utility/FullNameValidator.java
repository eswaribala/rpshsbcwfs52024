package com.hsbc.utility;

import com.hsbc.models.Customer;
import com.hsbc.models.CustomerType;
import com.hsbc.models.FullName;

import java.util.Random;

public class FullNameValidator {

    public static void main(String[] args){
        FullName fullName=new FullName();
        fullName.setFirstName("Parameswari ");
        Customer customer=new Customer();
        customer.setPassword("Test@2355");

        customer.setAccountNo(new Random().nextInt(1000000));
        customer.setCustomerType(CustomerType.SA);
        System.out.println(customer.getAccountNo());

    }
}
