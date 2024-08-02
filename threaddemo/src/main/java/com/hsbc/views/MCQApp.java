package com.hsbc.views;

import com.hsbc.dal.MCQDAL;
import com.hsbc.dal.MCQImpl;
import com.hsbc.models.Answer;
import com.hsbc.models.Question;

import java.io.IOException;

public class MCQApp {

    public static void main(String[] args){
        MCQDAL mcqdal=new MCQImpl();
        Answer[] answers=null;
        try {
            for(Question question: mcqdal.getQuestions()){
                System.out.print(question.getQuestionNo()+"."+question.getQuestionText());
                System.out.println("\n");
               answers=question.getAnswers();
              for(int i=0;i<4;i++){
                  System.out.println(answers[i].getAnswerId()+1+"."+answers[i].getAnswerText());
              }
              System.out.println("=========================================");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
