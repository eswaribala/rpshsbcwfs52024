package com.hsbc.views;

import com.hsbc.facades.MidSquareGenerator;
import com.hsbc.facades.UUIDGenerator;

import java.util.Random;
import java.util.UUID;

public class LambdaDemo {
    public static void main(String... args){
        UUIDGenerator uuidGenerator=()->{
            return UUID.randomUUID().toString();
        };

        System.out.println(uuidGenerator.getUniqueRandomNumber());
        //midsquare method
        MidSquareGenerator midSquareGenerator=(num1,num2)->{
            System.out.println(num1+","+num2);
            String data=String.valueOf(num1)+String.valueOf(num2);
            String result=null;
            if(data.length()%2==0){
                result=String.valueOf(data.charAt(data.length()/2-1)+""+data.charAt(data.length()/2));
            }else{
               result=String.valueOf(data.charAt(data.length()/2));
            }
              return Float.parseFloat(result);
        };

           Float value= midSquareGenerator.getMidSquare(
              new Random().nextInt(100,999),
              new Random().nextInt(100,999));
           String convValue=String.valueOf(value);
          System.out.println( convValue.charAt(0)+","+convValue.charAt(1));
         int first= Character.getNumericValue(convValue.charAt(0));
          int second= Character.getNumericValue(convValue.charAt(1));

           System.out.println((first+second)/2);



    }
}
