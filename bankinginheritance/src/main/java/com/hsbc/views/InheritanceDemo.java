package com.hsbc.views;

import com.hsbc.entities.Corporate;
import com.hsbc.entities.Individual;
import com.hsbc.entities.SavingsAccount;
import com.hsbc.models.*;

import java.time.LocalDate;
import java.util.Random;

public class InheritanceDemo {
    public static void main(String[] args){
        Individual individual=new Individual(new Random().nextInt(10000,50000),
                new FullName("Parameswari","Bala",""),
                9952032862L,"Param@gmail.com","Test@123",
                Gender.FEMALE, LocalDate.of(new Random().nextInt(1970,1999),
                new Random().nextInt(1,12),
                new Random().nextInt(1,27)));

        Corporate corporate =new Corporate(new Random().nextInt(10000,50000),
                new FullName("VHEB Consulting","",""),
                8056010299L,"vhebcompany@gmail.com",
                "Test@123", CompanyType.PRIVATE);
       // System.out.println(individual);
       // System.out.println(corporate);

        //type casting
        Customer customer=individual;
       // System.out.println(customer);
        //super class object cannot be assigned to subtype
       // Individual individualObj= new Customer();

      Customer[] customers=new Customer[3];
      customers[0]=individual;
      customers[1]=corporate;
      customers[2]=new Customer();
      //print
      for(Customer customerObj: customers){
          if(customerObj instanceof  Individual){
              System.out.println("Individual Instance.....");
              System.out.println(customerObj);
          } else if (customerObj instanceof  Corporate) {
              System.out.println("Corporate Instance.....");
              System.out.println(customerObj);

          }else {
              System.out.println("Customer Instance.....");
              System.out.println(customerObj);
          }

      }

      //test inherited data members
        Account account=new Account(true);
        SavingsAccount savingsAccount=new SavingsAccount(false);
        savingsAccount.setStatus(true);
        System.out.println(savingsAccount.isStatus());






    }
}
