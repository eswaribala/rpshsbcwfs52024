package com.hsbc.utility;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class TraineeSorter {
    public static void main(String[] args){
        String[] trainees=new String[]{"Parameswari Bala",
                "Bala",""," ","Karam","Pavan","Sreenija","Shwetha"};

        String data="Returns a canonical representation for the string object.\n" +
                "A pool of strings, initially empty, is maintained privately by the class String.\n" +
                "\n" +
                "When the intern method is invoked, if the pool already contains a string equal " +
                "to this String object as determined by the equals(Object) method, " +
                "then the string from the pool is returned. Otherwise, this String object is " +
                "added to the pool and a reference to this String object is returned.\n" +
                "\n" +
                "It follows that for any two strings s and t, s.intern() == t.intern() " +
                "is true if and only if s.equals(t) is true.\n" +
                "\n" +
                "All literal strings and string-valued constant expressions are interned. " +
                "String literals are defined in section 3.10.5 of the The Java Language Specification.";

        Arrays.sort(trainees);
        for(String trainee:trainees){
            System.out.println(trainee+"->"+trainee.isEmpty()+"->"+trainee.isBlank());
            //System.out.println(new StringBuilder(trainee).reverse());
           // System.out.println(trainee);
        }

        //lines
        Stream<String> streamedData =data.lines();

        //read streamed data
        for(Object object : streamedData.toArray()){
            System.out.println(object);
        }

    }

}
