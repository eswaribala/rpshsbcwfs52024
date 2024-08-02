package com.hsbc.views;

import com.hsbc.dal.MCQDAL;
import com.hsbc.dal.MCQImpl;
import com.hsbc.models.Answer;
import com.hsbc.models.MCQThread;
import com.hsbc.models.Question;

import java.io.IOException;
import java.util.Scanner;

public class MCQApp {
    public static void main(String[] args){
        MCQThread mcqThread=new MCQThread();
        mcqThread.start();
        int answer=0;
        try(Scanner scanner=new Scanner(System.in)){
            System.out.println("Enter your option....");
            answer=scanner.nextInt();
            if((answer>0)&&(answer<=4)){
                mcqThread.interrupt();
            }
        }

    }
}
