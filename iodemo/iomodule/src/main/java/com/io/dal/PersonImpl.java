package com.io.dal;

import com.io.models.Person;

import java.io.*;
import java.time.LocalDate;

public class PersonImpl implements PersonDAL{
    private File file;

    public  PersonImpl(String dirName,String fileName) throws IOException {
        //create dir
        file=new File(dirName);
        if(!file.exists()){
            file.mkdir();
        }else{
            System.out.println("Directory Exists");
        }
        //file creation
        file=new File(dirName,fileName);
        if(!file.exists()){
            file.createNewFile();
        }else{
            System.out.println("File Already Exists");
        }



    }
    @Override
    public boolean addPerson(Person person) throws IOException {
        try(FileWriter fileWriter=new FileWriter(file,true);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter)){
            bufferedWriter.write(person.getName());
            bufferedWriter.write(",");
            bufferedWriter.write(person.getDob().toString());
            bufferedWriter.write("\n");
        }
        return true;
    }

    @Override
    public Person[] getPersons() throws IOException {
        Person[] persons=new Person[countLines()];
        String line=null;
        String[] data=null;
        int pos=0;
        try(FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader)){
            while((line=bufferedReader.readLine())!=null){
                data=line.split(",");
                persons[pos]=new Person(data[0],
                        LocalDate.parse(data[1]));
                pos++;
            }
        }
        return persons;
    }

    public int countLines() throws IOException {
        int count=0;
        try(FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader)){
             while(bufferedReader.readLine()!=null){
                 count++;
             }

        }
        return count;
    }

}
