package com.hsbc.views;

import com.hsbc.dal.CDDAL;
import com.hsbc.dal.CDImpl;
import com.hsbc.models.CD;

import java.util.Random;

public class CDApp {

    public static void main(String[] args){

        //data storage layer
        CDDAL cddal=new CDImpl();
        //call add cd
        addCds(cddal);
        //view cds
        for(CD cd: cddal.getSortedCds()){
            System.out.println(cd);
        }
    }

    public static void addCds(CDDAL cddal){

        for(int count=0;count<100;count++){
            cddal.addCD(new CD("title"+new Random().nextInt(),
                    "Singer"+count));
        }

    }

}
