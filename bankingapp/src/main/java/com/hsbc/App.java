package com.hsbc;

import com.hsbc.models.Address;
import com.hsbc.models.Customer;
import com.hsbc.models.FullName;

import java.util.Random;
import java.util.Scanner;
public class App {
   public static void main(String[] args){
      //object creation
      Customer customer=new Customer();
     Scanner scanner=new Scanner(System.in);
      //account no
      customer.setAccountNo(new Random().nextInt(100000));
      //reading first name
      System.out.println("Enter First Name");
      String firstName=scanner.nextLine();
       //reading last name
       System.out.println("Enter Last Name");
       String lastName=scanner.nextLine();
       //assigning the name
      customer.setName(new FullName(firstName,lastName,""));
       //reading email
       System.out.println("Enter Email");
       customer.setEmail(scanner.nextLine());
       //reading password
       System.out.println("Enter Password");
       customer.setPassword(scanner.nextLine());
       //reading contactno
       System.out.println("Enter ContactNo");
       customer.setContactNo(scanner.nextLong());
       scanner.nextLine();
       System.out.println("Enter no of addresses");
       int size=scanner.nextInt();
       scanner.nextLine();

       Address[] addresses=new Address[size];
       addresses[0]=new Address();
       addresses[0].setDoorNo("12");
       addresses[0].setStreetName("Gandhi Street");
       addresses[0].setCity("Chennai");
       addresses[0].setState("TN");
       addresses[0].setPinCode(602024);
       customer.setAddresses(addresses);


       //to display customer values
       System.out.println(customer);


    }
}
