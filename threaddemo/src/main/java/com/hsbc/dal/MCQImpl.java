package com.hsbc.dal;

import com.hsbc.models.Answer;
import com.hsbc.models.Question;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MCQImpl implements MCQDAL{

    private File file;


    @Override
    public Question[] getQuestions() throws IOException {
        file=new File("MCQ.csv");
        Question[] questions=new Question[countLines()];
        Answer[] answers=null;
        String line=null;
        String[] data=null;
        int pos=0;
        try(FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader)){
            while((line=bufferedReader.readLine())!=null){
                data=line.split(",");
                int k=2;
                answers=new Answer[4];
                for(int i=0;i<4;i++){
                    answers[i]=new Answer(i,data[k]);
                    k++;
                }
                questions[pos]=new Question(Integer.parseInt(data[0]),data[1],answers);
                pos++;
            }
        }
        return questions;
    }

    private int countLines() throws IOException {
        String line=null;
        int count=0;
        file=new File("MCQ.csv");
        try(FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader)){
            while((line=bufferedReader.readLine())!=null){
             count++;
            }
        }
        return count;
    }
}
