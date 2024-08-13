package com.hsbc;

import com.hsbc.models.*;
import com.hsbc.storage.MedicineDAL;
import com.hsbc.storage.MedicineImpl;
import com.hsbc.storage.OTPGenerator;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MedicineDAL medicineDAL=new MedicineImpl();
        Employee employee=new Employee(1200,
                140000,"Chennai",
                Role.Administrator);
          /*
        Medicine medicine=null;
        Optional<Medicine> optional=null;
        if(employee.getRole().equals(Role.Administrator)) {
            for (int count = 0; count < 100; count++)
                medicineDAL.addMedicine(createMedicine());
        }

        try {
            System.out.println(medicineDAL.purchaseMedicines(medicineDAL.getAllMedicines()
                    .stream().map(m->m.getCode()).filter(m->m.longValue()%2==0).toList()
                   ));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/
        try {
            System.out.println(medicineDAL.generateReport());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //display medicines
      //  medicineDAL.getAllMedicines().stream().forEach(System.out::println);

        //sort by price
        /*
        medicineDAL.getAllMedicines().stream().sorted((m1,m2)->{
            if(m1.getPrice()>m2.getPrice())
                return 1;
            else if (m1.getPrice()<m2.getPrice()) {
                return -1;

            }else
                return 0;
        }).forEach(System.out::println);


        List<String> names=  List.of("Parameswari","Bala","Suman","Jaya","Sandeep");

      Optional<String> optionalData= names.stream().filter(n->n.startsWith("S")).findAny();
      if(optionalData.isPresent())
      {
          System.out.println(optionalData.get());
      }

      //all match
        System.out.println(names.stream().allMatch(n->n.startsWith("S")));
        System.out.println(names.stream().anyMatch(n->n.startsWith("S")));


 */




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
