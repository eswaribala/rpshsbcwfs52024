package com.hsbc.dal;

import com.hsbc.models.Customer;

import java.util.Map;

public interface CustomerDAL {

    void addCustomer(Customer customer);
    Map<Long,Customer> getAllCustomers();
}
