package com.hsbc.views;

import java.util.HashSet;

public class SetDemo {

    public static void main(String[] args){

        HashSet<String> iccSet=new HashSet<String>();
        iccSet.add("Rohit");
        iccSet.add("Virat");
        iccSet.add("Ashwin");
        iccSet.add("Natarajan");
        HashSet<String> iplSet=new HashSet<String>();
        iplSet.add("Rohit");
        iplSet.add("Virat");
        iplSet.add("Hardik");
         //union
        // iccSet.addAll(iplSet);
        // System.out.println(iccSet);
        //intersection
        //iccSet.retainAll(iplSet);
        //System.out.println(iccSet);
        //minus
        iccSet.removeAll(iplSet);
        System.out.println(iccSet);

    }
}
