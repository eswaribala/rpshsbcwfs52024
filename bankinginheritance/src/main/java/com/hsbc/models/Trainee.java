package com.hsbc.models;

public class Trainee implements Cloneable {
    private long basicSalary;
    private int da;
    private String reportingLocation;

    public Trainee() {
    }

    public Trainee(long basicSalary, int da, String reportingLocation) {
        this.basicSalary = basicSalary;
        this.da = da;
        this.reportingLocation = reportingLocation;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "basicSalary=" + basicSalary +
                ", da=" + da +
                ", reportingLocation='" + reportingLocation + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
