package com.hsbc.models;

import java.util.Comparator;

public class IndividualSorter implements Comparator<Individual> {
    @Override
    public int compare(Individual o1, Individual o2) {


        if(o1.getAge()>o2.getAge())
            return 1;
        else if (o1.getAge()<o2.getAge()) {
            return -1;

        }else
            return 0;
    }
}
