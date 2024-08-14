package com.hsbc.models;

public class Medicine {
    private long medicineCode;

    public Medicine() {
    }

    public Medicine(long medicineCode) {
        this.medicineCode = medicineCode;
    }

    public long getMedicineCode() {
        return medicineCode;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineCode=" + medicineCode +
                '}';
    }
}
