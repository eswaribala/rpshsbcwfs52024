package com.globalclaim;
import com.github.javafaker.Faker;
import com.globalclaim.models.Address;
import com.globalclaim.models.Person;

import java.util.*;
import java.util.stream.Collectors;

public class ImmutableCollectionDemo {
    public static void main(String... args){
        //before java 9
        List<String> traineeNames=new ArrayList<>();
        traineeNames.add("Aditya");
        traineeNames.add("Devansh");
        traineeNames.add("karthik");
        traineeNames.add("Guru");
        traineeNames.add("Sreeja");
        traineeNames.add("Ajay");
        traineeNames.add("Pavan");
        //unmodifiable list
        List<String> backbenchers= Collections.unmodifiableList(traineeNames);
        //backbenchers.add("Riddhiga"); //error
        //After Java 9 immutable collection
        List<String> names=List.of("Yash","Rujutha","Riddhiga");
        //names.add("Sangam");//error
       //Map with stream
        generatePersonData().entrySet().
                stream()
                .map(p->p.getKey()+","+p.getValue())
                .forEach(System.out::println);
        //immutable List
      List<String> data= generatePersonData().entrySet().
                stream()
                .map(p->p.getKey()+","+p.getValue())
                .collect(Collectors.toUnmodifiableList());

       //data.add("x"); error
      //immutable map before java 9
      Map<Person,Address> mapData=generatePersonData().entrySet().stream()
              .collect(Collectors.toUnmodifiableMap( p -> p.getKey(),
                      p -> p.getValue()));

     //immutable map after java 9
        Map.of(1,"Parameswari",2,"Bala");

      //immutable map with java10
      Map<Person,Address> mapData10=  Map.copyOf(generatePersonData());
     // mapData10.put(new Person(),new Address()); error

    }

    public static Map<Person, Address> generatePersonData(){
        Map<Person, Address> personAddressMap=new HashMap<>();
        Faker faker=null;
        for(int count=0;count<100;count++){
            faker=new Faker();
            personAddressMap.put(new Person(faker.number().numberBetween(1,10000),
                            faker.name().fullName()),
                            new Address(faker.address().buildingNumber(),
                            faker.address().streetName(),
                            faker.address().city()
                            ,faker.address().zipCode()));
        }

        return personAddressMap;

    }


}
