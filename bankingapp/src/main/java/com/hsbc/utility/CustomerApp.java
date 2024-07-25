package com.hsbc.utility;

import com.hsbc.models.Customer;
import com.hsbc.models.CustomerSorter;
import com.hsbc.models.FullName;

import java.util.Arrays;
import java.util.Random;

public class CustomerApp {
    public static void main(String[] args){
        Customer[] customers=new Customer[10];
        for(int i=0;i<10;i++){
            customers[i]=new Customer();
            customers[i].setAccountNo(new Random().nextInt(1000000));
            customers[i].setName(new FullName("customer",String.valueOf(i),""));
            customers[i].setEmail("customer"+i+"@gmail.com");
            customers[i].setPassword("Test@123");
            customers[i].setContactNo(999998899+new Random().nextInt(1000000));
            customers[i].setAddresses(null);
        }
        //display unsorted customers
        /*for(Customer customer:customers){
            System.out.println(customer);
        }*/
        //display sorted customers
        Arrays.sort(customers,new CustomerSorter());
        for(Customer customer:customers){
            System.out.println(customer);
        }

    }
}
