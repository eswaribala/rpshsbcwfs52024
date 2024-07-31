package com.hsbc.entities;

import com.hsbc.models.CompanyType;
import com.hsbc.models.Customer;
import com.hsbc.models.FullName;

public class Corporate extends Customer {

    private CompanyType companyType;

    public Corporate() {
    }

    public Corporate(long accountNo, FullName name, long contactNo, String email, String password, CompanyType companyType) {
        super(accountNo, name, contactNo, email, password);
        this.companyType = companyType;
    }

    @Override
    public String toString() {
        return "Corporate{" +super.toString()+
                "companyType=" + companyType +
                '}';
    }
}
