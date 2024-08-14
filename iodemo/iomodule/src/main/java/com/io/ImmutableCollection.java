package com.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ImmutableCollection {

    public static void main(String[] args){
        //before java 9
        List<String> sportList = new ArrayList<String>();

        sportList.add("Hockey");
        sportList.add("Cricket");
        sportList.add("Tennis");

        List<String> unModifiableSportList = Collections.unmodifiableList(sportList);

        System.out.println(sportList);    //Output : [Hockey, Cricket, Tennis]

        System.out.println(unModifiableSportList);    //Output : [Hockey, Cricket, Tennis]

       // unModifiableSportList.add("Wrestling");     //It gives run-time error

        sportList.add("Kabaddi");      //It gives no error and will be reflected in unModifiableSportList

        System.out.println(sportList);    //Output : [Hockey, Cricket, Tennis, Kabaddi]

        System.out.println(unModifiableSportList);    //Output : [Hockey, Cricket, Tennis, Kabaddi]

        //after java 9
        List<String> sportsList = List.of("Hockey","Cricket","Tennis");
       // sportsList.add("Wrestling");

        //stream in 10
      List<String> items=  sportsList.stream().filter(s->s.startsWith("T")).collect(Collectors.toUnmodifiableList());

      //items.add("Table Tennis");

     List<String> copiedItems=List.copyOf(items);
     //copiedItems.add("Table Tennis");


    }
}
