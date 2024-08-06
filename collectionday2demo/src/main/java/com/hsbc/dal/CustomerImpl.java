package com.hsbc.dal;

import com.hsbc.models.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CustomerImpl implements CustomerDAL {
     private Map<Long,Customer> customerMap;
     public CustomerImpl(){
         customerMap=new HashMap<Long,Customer>();
     }
    @Override
    public void addCustomer(Customer customer) {
       customerMap.put(new Random().nextLong(9999999000L,9999999999L),
               customer);
    }

    @Override
    public Map<Long, Customer> getAllCustomers() {
        return customerMap;
    }
}
