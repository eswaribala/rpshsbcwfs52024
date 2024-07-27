package com.hsbc.models;

import java.util.Comparator;

public class CustomerSorter implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {

       return  o1.getAccountNo().compareTo(o2.getAccountNo());
        /*if(o1.getContactNo()>o2.getContactNo())
            return 1;
        else if (o1.getContactNo()<o2.getContactNo()) {
            return -1;

        }else
            return 0;*/
    }
}
