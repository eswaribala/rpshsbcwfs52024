package com.hsbc.views;

import com.hsbc.facades.CreditCard;
import com.hsbc.facades.GoldCreditCard;
import com.hsbc.facades.PlatinumCreditCard;
import com.hsbc.facades.SilverCreditCard;

import java.util.Scanner;

public class CreditCardApp {

    public static void main(String[] args){
        CreditCard creditCard=null;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Choice(EMI/FOREX)");
        switch (scanner.nextLine()){
            case "EMI":
                creditCard=new PlatinumCreditCard();
                System.out.println("Generated Platinum Card");
                break;

            case "FOREX":
                creditCard=new GoldCreditCard();
                System.out.println("Generated Gold Card");
                break;
            default:
                 creditCard=new SilverCreditCard();
                System.out.println("Generated Silver Card");
                break;
        }





    }
}
