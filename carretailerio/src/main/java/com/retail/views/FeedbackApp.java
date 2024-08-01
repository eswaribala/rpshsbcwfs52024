package com.retail.views;

import com.retail.dal.DataStorage;
import com.retail.dal.DataStorageImpl;
import com.retail.dtos.FeedbackReport;
import com.retail.entities.Car;
import com.retail.entities.CustomerFeedback;
import com.retail.entities.ModelName;
import com.retail.exceptions.AverageComputationException;
import com.retail.exceptions.DrivingRatingException;
import com.retail.exceptions.SeatingRatingException;

import java.io.IOException;

public class FeedbackApp {

    public  static void main(String[] args){
        try {
            DataStorage dataStorage=new DataStorageImpl("backup","cars.csv","customerfeedback.csv");

          // addCars(dataStorage);
          // addCustomerFeedback(dataStorage);
          for(Car car:  dataStorage.getAllCars())
              System.out.println(car.getModelName()+","+car.getSeatingCapacity());

          for(FeedbackReport feedbackReport: dataStorage.getAllFeedback()){
              System.out.println(feedbackReport);
          }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addCars(DataStorage dataStorage){
        //add cars
        try {
            dataStorage.addCar(new Car(ModelName.FordEcoSport5,(byte)5));
            dataStorage.addCar(new Car(ModelName.Toyoto7,(byte)7));
            dataStorage.addCar(new Car(ModelName.Hyundai1204,(byte)4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void addCustomerFeedback(DataStorage dataStorage){
        //add feedback
        try {
            dataStorage.addCustomerFeedback(new
                    CustomerFeedback(
                    "Mukund", ModelName.FordEcoSport5, "Delhi",
                    4,
                    4));
            dataStorage.addCustomerFeedback(new
                    CustomerFeedback(
                    "Sakshi", ModelName.FordEcoSport5, "Delhi",
                    3,
                    4));
            dataStorage.addCustomerFeedback(new
                    CustomerFeedback(
                    "Rohit", ModelName.FordEcoSport5, "Delhi",
                    4,
                    4));
            dataStorage.addCustomerFeedback(new
                    CustomerFeedback(
                    "Srikanth", ModelName.Hyundai1204, "Delhi",
                    3,
                    3));
            dataStorage.addCustomerFeedback(new
                    CustomerFeedback(
                    "Suman", ModelName.Hyundai1204, "Delhi",
                    2,
                    3));
            dataStorage.addCustomerFeedback(new
                    CustomerFeedback(
                    "Suman", ModelName.Toyoto7, "Delhi",
                    4,
                    3));

        } catch (IOException e) {
            //throw new RuntimeException(e);
        } catch (DrivingRatingException e) {
           // throw new RuntimeException(e);
        } catch (SeatingRatingException e) {
           // throw new RuntimeException(e);
        }

    }



}
