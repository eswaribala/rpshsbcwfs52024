package com.hsbc.dal;

import com.hsbc.models.Person;

import java.io.*;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonImpl implements PersonDAL{
    private File file;

    public PersonImpl() {
    }

    public  PersonImpl(String dirName, String fileName) throws IOException {
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
    public List<Person> getPersons() throws IOException {
        List<Person> persons=new ArrayList<Person>();
        String line=null;
        String[] data=null;

        try(FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader)){
            while((line=bufferedReader.readLine())!=null){
                data=line.split(",");
                persons.add(new Person(data[0],
                        LocalDate.parse(data[1])));
            }
        }
        return persons;
    }



}
