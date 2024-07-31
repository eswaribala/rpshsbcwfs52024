package com.hsbc.views;

import com.hsbc.models.Trainee;

public class TraineeCloner {

    public static void main(String[] args){
        Trainee trainee1=new Trainee(45000,
                15000,"Pune");
        Trainee[] trainees=new Trainee[200];
        for(int i=0;i<200;i++) {
            try {
                trainees[i] = (Trainee) trainee1.clone();
                System.out.println(trainees[i].hashCode());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(trainee1.hashCode());

    }

}
