package com.hsbc.views;

import com.hsbc.dal.TravellerDAL;
import com.hsbc.dal.TravellerImpl;
import com.hsbc.models.Traveller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class TravellerApp {
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter no of travellers");
        int count=scanner.nextInt();
        try {
            TravellerDAL travellerDAL=new TravellerImpl("store",
                    "travellerinfo.dat");

        //  addTraveller(travellerDAL,count);
           travellerDAL.close();
           for(Traveller traveller: travellerDAL.getTravellers(count)){
               if(traveller !=null )
                  System.out.println(traveller);
           }

        } catch (IOException | ClassNotFoundException e) {
           // throw new RuntimeException(e);
        }

    }

    public static  void addTraveller(TravellerDAL travellerDAL, int size) throws IOException {
        for(int count=0;count<size;count++){
            travellerDAL.addTraveller(new Traveller("person"+count,
                    LocalDate.of(new Random().nextInt(1970,2023),
                            new Random().nextInt(1,12),
                            new Random().nextInt(1,27)
                    ),"destination"+count,new Random().nextInt(10000)));
        }

    }
}
