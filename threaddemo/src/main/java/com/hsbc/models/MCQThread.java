package com.hsbc.models;

import com.hsbc.dal.MCQDAL;
import com.hsbc.dal.MCQImpl;

import java.io.IOException;

public class MCQThread extends Thread {
    private MCQDAL mcqdal;
    private Answer[] answers;
    @Override
    public void run() {
        mcqdal=new MCQImpl();
        try {
            for(Question question: mcqdal.getQuestions()){
                System.out.print(question.getQuestionNo()+"."+question.getQuestionText());
                System.out.println("\n");
                answers=question.getAnswers();
                for(int i=0;i<4;i++){
                    System.out.println(answers[i].getAnswerId()+1+"."+answers[i].getAnswerText());
                }
                System.out.println("=========================================");
                Thread.sleep(5000);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
           System.out.println("Moving to Next Question.....");

        }
    }
}
