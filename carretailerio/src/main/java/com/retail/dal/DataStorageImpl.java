package com.retail.dal;

import com.retail.dtos.FeedbackReport;
import com.retail.entities.Car;
import com.retail.entities.CustomerFeedback;
import com.retail.entities.ModelName;
import com.retail.exceptions.AverageComputationException;
import com.retail.exceptions.DrivingRatingException;
import com.retail.exceptions.SeatingRatingException;
import com.retail.exceptions.StorageException;

import java.io.*;

public class DataStorageImpl implements DataStorage{

    private File carFile,customerFeedbackFile;


    public  DataStorageImpl(String dirName,String carFileName, String customerFeedbackFileName) throws IOException {
        carFile=new File(dirName);
        //create directory
        if(!carFile.exists()){
            carFile.mkdir();
            System.out.println(carFile.isDirectory());
        }else {
            System.out.println("Directory already exists");
        }

        carFile=new File(dirName,carFileName);
        //create file
        if(!carFile.exists()){
            carFile.createNewFile();
        }else {
            System.out.println("Car File already exists");
        }

        customerFeedbackFile=new File(dirName,customerFeedbackFileName);
        //create file
        if(!customerFeedbackFile.exists()){
            customerFeedbackFile.createNewFile();
        }else {
            System.out.println("Customer Feedback File already exists");
        }


    }


    @Override
    public boolean addCar(Car car) throws IOException {
      //auto closeable
        try (FileWriter fileWriter = new FileWriter(carFile,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(car.getModelName().toString());
            bufferedWriter.write(",");
            bufferedWriter.write(String.valueOf(car.getSeatingCapacity()));
            bufferedWriter.write("\n");
        }
        return true;
    }

    @Override
    public boolean addCustomerFeedback(CustomerFeedback customerFeedback) throws DrivingRatingException, SeatingRatingException, IOException {

        //auto closeable
        try (FileWriter fileWriter = new FileWriter(customerFeedbackFile,true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(customerFeedback.getName());
            bufferedWriter.write(",");
            bufferedWriter.write(customerFeedback.getModelName().toString());
            bufferedWriter.write(",");
            bufferedWriter.write(customerFeedback.getCity());
            bufferedWriter.write(",");
            bufferedWriter.write(String.valueOf(customerFeedback.getSeatComfortRating()));
            bufferedWriter.write(",");
            bufferedWriter.write(String.valueOf(customerFeedback.getDrivingComfortRating()));
            bufferedWriter.write("\n");
        }
        return true;
    }

    @Override
    public Car[] getAllCars() throws IOException {
        String line=null;
        String[] data=null;
        Car[] cars=new Car[getCarFileLinesCount()];
        int pos=0;
        try(FileReader fileReader=new FileReader(carFile);
        BufferedReader  bufferedReader=new BufferedReader(fileReader)
        ){
             while((line=bufferedReader.readLine())!=null){
                data=line.split(",");
                 cars[pos]=new Car(Enum.valueOf(ModelName.class,data[0]),Byte.parseByte(data[1]));
                 pos++;
             }
        }
         return cars;
    }

    @Override
    public FeedbackReport[] getAllFeedback() throws IOException {
        FeedbackReport[] feedbackReports=new FeedbackReport[ModelName.values().length];

        Car[] cars=this.getAllCars();
        int data[][]=new int[ModelName.values().length][2];
        for(int row=0;row<data.length;row++){
            for(int col=0;col<data[row].length;col++){
                data[row][col]=0;
            }
        }
        for(CustomerFeedback customerFeedback:getDataFromFile()){
            for(int i=0;i<cars.length;i++){
                if(customerFeedback.getModelName().equals(cars[i].getModelName())){
                    //accumulate the feedback
                    data[i][0]+=(customerFeedback.getSeatComfortRating()+customerFeedback.getDrivingComfortRating())/2;
                    //increment the count
                    data[i][1]++;
                }
            }
        }
        for (int i = 0; i < ModelName.values().length; i++) {
            try {
                feedbackReports[i] = new FeedbackReport(cars[i].getModelName(), cars[i].getSeatingCapacity(),
                        data[i][0]/(data[i][1]));
            }catch(ArithmeticException e){

                throw new AverageComputationException("Average Computation Failed due to o cars ");
            }


        }
        return feedbackReports;

    }


    public CustomerFeedback[] getDataFromFile() throws IOException {
        CustomerFeedback[] customerFeedbacks=new CustomerFeedback[getCustomerFeedbackFileLinesCount()];
        String line=null;
        String[] data=null;
        int pos=0;
        //read the file
        try(FileReader fileReader=new FileReader(customerFeedbackFile);
            BufferedReader bufferedReader=new BufferedReader(fileReader)
        ) {
            while((line=bufferedReader.readLine())!=null){
                data=line.split(",");
                customerFeedbacks[pos]=new CustomerFeedback(data[0],
                        Enum.valueOf(ModelName.class,data[1]),
                        data[2],
                        Integer.parseInt(data[3]),
                        Integer.parseInt(data[4]));
                pos++;
            }
        }
        return customerFeedbacks;

    }




    public int getCarFileLinesCount() throws IOException {
        String line=null;
        int count=0;
        try(FileReader fileReader=new FileReader(carFile);
            BufferedReader  bufferedReader=new BufferedReader(fileReader)
        ){

            while((line=bufferedReader.readLine())!=null){
                count++;

            }

        }
        return count;
    }

    public int getCustomerFeedbackFileLinesCount() throws IOException {
        String line=null;
        int count=0;
        try(FileReader fileReader=new FileReader(customerFeedbackFile);
            BufferedReader  bufferedReader=new BufferedReader(fileReader)
        ){

            while((line=bufferedReader.readLine())!=null){
                count++;

            }

        }
        return count;
    }

}
