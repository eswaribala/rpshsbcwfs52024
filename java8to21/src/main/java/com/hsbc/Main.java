package com.hsbc;

import com.hsbc.models.*;
import com.hsbc.storage.MedicineDAL;
import com.hsbc.storage.MedicineImpl;
import com.hsbc.storage.OTPGenerator;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        MedicineDAL medicineDAL=new MedicineImpl();
        Employee employee=new Employee(1200,
                140000,"Chennai",
                Role.Administrator);
        Medicine medicine=null;
        Optional<Medicine> optional=null;
        if(employee.getRole().equals(Role.Administrator)) {
            for (int count = 0; count < 100; count++)
                medicineDAL.addMedicine(createMedicine());
        }



        /* optional= medicineDAL.updateMedicine(medicine.getCode(),100,2000);
           if(optional.isPresent()){
               System.out.println(optional.get());
           }else
               System.out.println("Medicine not present");*/




    }

    public static Medicine createMedicine(){
        return new Medicine(new Random()
                .nextLong(1000,10000),
                "medicine"+new Random().nextInt(1,1000),
                MedicineType.REGULAR,new Random().nextInt(1,1000),
                new Random().nextInt(100,2000));
    }

}











       /*
          //role of built in functional interfaces
        //Function declaration
        Function<Medicine, MedicineType> medicineTypeFunction=(medicine)->{
            return medicine.getMedicineType();
        };
        //Function Invocation
       System.out.println( medicineTypeFunction.apply(new Medicine(new Random()
               .nextLong(1000,10000),
                "Dolo 500", MedicineType.REGULAR,6,75)));

       //BiFunction
        BiFunction<Medicine,Medicine,Boolean> medicineBiFunction=(medicine1,medicine2)->{

            if(medicine1.getPrice()>medicine2.getPrice()){
                return true;
            }else if(medicine1.getPrice() < medicine2.getPrice()){
                return false;
            }else{
                return true;
            }

        };

        //Bi function invocation
        System.out.println( medicineBiFunction.apply(new Medicine(new Random()
                .nextLong(1000,10000),
                "Dolo 500", MedicineType.REGULAR,6,75)
                ,new Medicine(new Random()
                .nextLong(1000,10000),
                "Paracetamol 250", MedicineType.REGULAR,6,175)));

        //predicate

        Predicate<Medicine> medicinePredicate=(medicine)->{
          if(medicine.getMedicineType().equals(MedicineType.REGULAR))
              return true;
          else
              return false;
        };

       System.out.println(medicinePredicate.test(new Medicine(new Random()
                .nextLong(1000,10000),
                "Paracetamol 250", MedicineType.REGULAR,6,175)));


       //supplier
        //Supplier makes constructor reference
        Supplier<Medicine> medicineSupplier=Medicine::new;
        //Object created or not
        if(medicineSupplier.get()!=null)
            System.out.println("Object created");
        else
            System.out.println("Object not created");

        //supplier with method reference
         Supplier<Integer> otpGeneratorSupplier=OTPGenerator::getOTP;

         System.out.println(otpGeneratorSupplier.get());

         //consumer with non static method reference
        Consumer<Medicine> medicineConsumer=System.out::println;

        medicineConsumer.accept(new Medicine(new Random()
                .nextLong(1000,10000),
                "Paracetamol 250", MedicineType.REGULAR,6,175));

*/
