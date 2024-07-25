package com.hsbc.utility;

import java.util.Scanner;

public class JaggedArray {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter no of customers");
        int rows=scanner.nextInt();
        scanner.nextLine();
        int[][] premiums=new int[rows][];
        //read the no of cols
        for(int i=0;i<premiums.length;i++){
            System.out.println("Enter no of premiums");
            int cols=scanner.nextInt();
            scanner.nextLine();
            premiums[i]=new int[cols];
            for(int j=0;j<premiums[i].length;j++){
                System.out.println("Enter premium Amount for col no"+j);
                int amount=scanner.nextInt();
                scanner.nextLine();
                premiums[i][j]=amount;
            }
        }
        //display values
        for(int i=0;i<premiums.length;i++){
            for(int j=0;j<premiums[i].length;j++){
                System.out.print(premiums[i][j]+"\t");
            }
            System.out.println("\n");
        }



    }

}
