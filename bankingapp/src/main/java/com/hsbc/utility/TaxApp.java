package com.hsbc.utility;

import com.hsbc.models.Gender;
import com.hsbc.models.Tax;

import java.util.Scanner;

public class TaxApp {
    public static void main(String[] args){
        Tax tax=new Tax();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Gender");
        tax.setGender(Gender.valueOf(scanner.nextLine()));
        System.out.println("Enter Salary");
        tax.setSalary(scanner.nextLong());
        scanner.nextLine();

        if(tax.getGender().equals(Gender.MALE)){
            if((tax.getSalary()>=0)&&(tax.getSalary()<=180000)){
                tax.setComputedTax(0);
            } else if ((tax.getSalary()>=1810000)&&(tax.getSalary()<=500000)) {
                 tax.setComputedTax(tax.getSalary()*0.10);
            } else if ((tax.getSalary()>=500001)&&(tax.getSalary()<=800000)) {
                 tax.setComputedTax(tax.getSalary()*0.20);
            }else{
                tax.setComputedTax(tax.getSalary()*0.30);
            }

        }
        if(tax.getGender().equals(Gender.FEMALE)){
            if((tax.getSalary()>=0)&&(tax.getSalary()<=190000)){
                tax.setComputedTax(0);
            } else if ((tax.getSalary()>=1910000)&&(tax.getSalary()<=500000)) {
                tax.setComputedTax(tax.getSalary()*0.10);
            } else if ((tax.getSalary()>=500001)&&(tax.getSalary()<=800000)) {
                tax.setComputedTax(tax.getSalary()*0.20);
            }else{
                tax.setComputedTax(tax.getSalary()*0.30);
            }
        }

        System.out.println(tax);


    }
}
