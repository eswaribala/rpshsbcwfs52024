package com.hsbc.dal;

import com.hsbc.models.Traveller;

import java.io.*;

public class TravellerImpl implements TravellerDAL{
    private File file;
    private FileOutputStream fileOutputStream;
    private   ObjectOutputStream objectOutputStream;


    public TravellerImpl(String dirName,String fileName) throws IOException {
       file=new File(dirName,fileName);
       if(!file.exists())
           file.createNewFile();
       else
           System.out.println("File Exists");
        boolean append = file.exists();
        fileOutputStream=new FileOutputStream(file,append);
        objectOutputStream=new ObjectOutputStream(fileOutputStream);

    }
    @Override
    public boolean addTraveller(Traveller traveller) throws IOException {

        objectOutputStream.writeObject(traveller);
       return true;

    }

    @Override
    public Traveller[] getTravellers(int size) throws IOException, ClassNotFoundException {
       Traveller[] travellers=new Traveller[size];
       int pos=0;

        FileInputStream fileInputStream=new FileInputStream(file);
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

           Object obj = null;
           try {
               while ((obj =objectInputStream.readObject()) != null) {
                   travellers[pos] =(Traveller) obj;
                   pos++;
                   obj=null;
               }
           } catch (EOFException e) {

           }finally {
               fileInputStream.close();
               objectInputStream.close();
               return travellers;


           }



    }

    @Override
    public  void close() throws IOException {
        objectOutputStream.close();
        fileOutputStream.close();
    }

}
