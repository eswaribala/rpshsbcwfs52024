package com.hsbc.utility;

import com.hsbc.models.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Random;

public class IndividualApp {

    public static void main(String[] args){
        Individual[] individuals=new Individual[10];
        for(int i=0;i<10;i++){
            individuals[i]=new Individual();
            individuals[i].setAccountNo(Customer.sequence++);
            individuals[i].setName(new FullName("customer",String.valueOf(i),""));
            individuals[i].setEmail("customer"+i+"@gmail.com");
            individuals[i].setPassword("Test@2355");
            individuals[i].setContactNo(999998899+new Random().nextInt(1000000));
            individuals[i].setAddresses(null);
            individuals[i].setDob(LocalDate.of(
                    new Random().nextInt(1970,2024),
                    new Random().nextInt(1,12),
                    new Random().nextInt(1,27)
                    ));
            if(i%2==0)
             individuals[i].setGender(Gender.MALE);
            else
                individuals[i].setGender(Gender.FEMALE);

            individuals[i].setAge((byte)Period.between(individuals[i].getDob(),LocalDate.now()).getYears());

        }

        //display unsorted list
        for(Individual individual:individuals){
            System.out.println(individual);
        }
        Arrays.sort(individuals,new IndividualSorter());
        System.out.println("After Sorting.....");
        for(Individual individual:individuals){
            System.out.println(individual);
        }
    }
}
