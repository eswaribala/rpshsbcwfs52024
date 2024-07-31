package com.hsbc.models;

public class Customer {
    protected long accountNo;
    protected FullName name;
    protected long contactNo;
    protected String email;
    protected String password;

    public boolean active;

    public Customer() {
    }

    public Customer(long accountNo, FullName name, long contactNo, String email, String password) {
        this.accountNo = accountNo;
        this.name = name;
        this.contactNo = contactNo;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountNo=" + accountNo +
                ", name=" + name +
                ", contactNo=" + contactNo +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
