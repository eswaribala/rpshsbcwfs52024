package com.hsbc.utility;

import com.hsbc.models.Customer;
import com.hsbc.models.CustomerSorter;
import com.hsbc.models.FullName;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CustomerApp {
    public static void main(String[] args){
        Customer[] customers=new Customer[3];
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<3;i++){
          System.out.println(Customer.getOTP());
          System.out.println("Enter OTP");
            customers[i]=new Customer(scanner.nextInt());
            scanner.nextLine();
           // customers[i].setAccountNo(new Random().nextInt(1000000));
            customers[i].setAccountNo(Customer.sequence++);
            customers[i].setName(new FullName("customer",String.valueOf(i),""));
            customers[i].setEmail("customer"+i+"@gmail.com");
            customers[i].setPassword("Test@2355");
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

        changePassword(customers[0]);
        System.out.println(customers[0]);
    }

    public static void changePassword(Customer customer){
        customer.setPassword("Test@4566");
    }

}
