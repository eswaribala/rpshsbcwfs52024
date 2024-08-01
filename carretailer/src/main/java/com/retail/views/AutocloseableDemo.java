package com.retail.views;

import java.util.Scanner;

public class AutocloseableDemo {
    public static void main(String[] args){
        //try with resources
        try(Scanner scanner=new Scanner(System.in)) {

            System.out.println("Enter Name");
            System.out.println(scanner.nextLine());
        }

    }

}
