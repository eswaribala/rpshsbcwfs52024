package com.hsbc.views;

import com.hsbc.entities.Individual;
import com.hsbc.models.FullName;
import com.hsbc.models.Gender;

import java.time.LocalDate;
import java.util.Random;

public class EqualsDemo {

    public static void main(String[] args){
        Individual individual1=new Individual(new Random().nextInt(10000,50000),
                new FullName("Parameswari","Bala",""),
                9952032862L,"Param@gmail.com","Test@123",
                Gender.FEMALE, LocalDate.of(new Random().nextInt(1970,1999),
                new Random().nextInt(1,12),
                new Random().nextInt(1,27)));
        Individual individual2=new Individual(new Random().nextInt(10000,50000),
                new FullName("Vignesh","Bala",""),
                9952032862L,"vignesh@gmail.com","Test@123",
                Gender.FEMALE, LocalDate.of(new Random().nextInt(1970,1999),
                new Random().nextInt(1,12),
                new Random().nextInt(1,27)));



        System.out.println(individual1.equals(individual2));

        System.out.println(individual1.hashCode());
        System.out.println(individual2.hashCode());
    }
}
