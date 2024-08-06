package com.hsbc.views;

import com.hsbc.dal.CustomerDAL;
import com.hsbc.dal.CustomerImpl;
import com.hsbc.models.Customer;

import java.util.*;

public class CustomerMapApp {
    public static void main(String... args){
        CustomerDAL customerDAL=new CustomerImpl();
        addCustomers(customerDAL);
        //retrieve customers
      Set<Map.Entry<Long,Customer>> set =
              customerDAL.getAllCustomers().entrySet();

      for(Map.Entry<Long,Customer> customerEntry : set){
          System.out.println(customerEntry.getKey()+","
                  +customerEntry.getValue());
      }

      //search customer by phone no
        try(Scanner scanner=new Scanner(System.in)){
            System.out.println("Enter Phone No");
            System.out.println(customerDAL.getAllCustomers()
                    .get(scanner.nextLong()));
        }



      /*
      Iterator<Map.Entry<Long,Customer>> itr= set.iterator();

       while(itr.hasNext()){
           Map.Entry<Long,Customer> customerEntry=itr.next();
           System.out.println(customerEntry.getKey()+","
                   +customerEntry.getValue());
       }
*/

    }

    public static void addCustomers(CustomerDAL customerDAL){
        List<String> cities=new ArrayList<String>();
        cities.add("Chennai");
        cities.add("Pune");
        cities.add("Bangalore");
        cities.add("Hyderabad");
        for(int count=0;count<100;count++) {
            customerDAL.addCustomer(new Customer("customer"+count
                    ,cities.get(count%4) ));
        }
    }
}
