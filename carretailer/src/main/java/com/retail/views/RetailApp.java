package com.retail.views;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RetailApp {
    private String[] cars;
    public static void main(String[] args){
        StackTraceElement[] stackTraceElements=null;
        Scanner scanner=new Scanner(System.in);
        String age=null;
        int ageValue=0;
        try {
            try {
                System.out.println(args.hashCode());
                System.out.println("Enter Age");
                age = scanner.nextLine();
                ageValue=Integer.parseInt(age);

                System.out.println(new RetailApp().cars.length);
                System.out.println(10 / args.length);

            } catch (ArithmeticException | NullPointerException | InputMismatchException | NumberFormatException e) {
               System.out.println(e.getClass().getCanonicalName());
                if (e instanceof  ArithmeticException){

               } else if (e instanceof NullPointerException) {


               } else if (e instanceof InputMismatchException) {
                   System.out.println("Input Mismatch Exception");
               }else {

               }

            } finally {

                scanner.close();
            }
            System.out.println("Finally....");
            System.out.println(new Random().nextInt(10000) + args.length);

        }catch (Exception e){


        }finally {

            System.out.println("Finally....");
        }


    }
}
