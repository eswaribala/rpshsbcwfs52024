package com.hsbc.models;

public class Branch {
    private String branchName;
    private String branchCode;
    private long branchPostalCode;

    private Address branchAddress;

    public Branch() {
    }

    public Branch(String branchName, String branchCode, long branchPostalCode, Address branchAddress) {
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.branchPostalCode = branchPostalCode;
        this.branchAddress = branchAddress;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchName='" + branchName + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", branchPostalCode=" + branchPostalCode +
                ", branchAddress=" + branchAddress +
                '}';
    }
}
