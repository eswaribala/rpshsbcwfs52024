package com.retail.view;

import com.retail.bal.ProductBL;
import com.retail.bal.ProductBLImpl;
import com.retail.dtos.ApparelDTO;
import com.retail.dtos.ElectronicsDTO;
import com.retail.dtos.FoodItemDTO;
import com.retail.entities.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class EveryDayApp {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter product array size");
        int size=scanner.nextInt();
        ProductBL productBL=new ProductBLImpl(size);
        scanner.nextLine();
       int count=0;
       int option=0;
       Product product=null;
        do{
           System.out.println("Choose The Type");
           System.out.println("1.Food Items");
            System.out.println("2.Apparel");
            System.out.println("3.Electronics");
           option=scanner.nextInt();
           scanner.nextLine();
           switch (option){
               case 1:
                   LocalDate dom=LocalDate.of(new Random().nextInt(2023,2024),
                           new Random().nextInt(1,12),
                           new Random().nextInt(1,27));

                 product=new FoodItems(new Random().nextInt(100,150),
                         "FoodItem"+count,
                         new Random().nextInt(25,250),
                         new Random().nextInt(1,100),
                         dom,
                         dom.plusMonths(6),true
                         );
                   productBL.addProduct(product);

                 break;
               case 2:

                   product=new Apparel(new Random().nextInt(100,150),
                           "Apparel"+count,
                           new Random().nextInt(2500,25000),
                           new Random().nextInt(1,100),
                           Size.MEDIUM,
                           Material.COTTON
                   );
                   productBL.addProduct(product);

                   break;
               case 3:

                   product=new Electronics(new Random().nextInt(100,150),
                           "Electronics"+count,
                           new Random().nextInt(25000,250000),
                           new Random().nextInt(1,100),
                           12
                   );
                   productBL.addProduct(product);

                   break;

           }
           count++;
        }while(count<size);

        //display the product

       for(FoodItemDTO foodItemDTO: productBL.getAllFoodItems()){
           System.out.println(foodItemDTO);
       }

        for(ApparelDTO apparelDTO: productBL.getAllApparels()){
            System.out.println(apparelDTO);
        }
        for(ElectronicsDTO electronicsDTO: productBL.getAllElectronics()){
            System.out.println(electronicsDTO);
        }
    }
}
