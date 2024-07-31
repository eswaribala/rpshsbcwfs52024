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

public class FeedbackApp {

    public  static void main(String[] args){
        DataStorage dataStorage=new DataStorageImpl(3,6);
        dataStorage.addCar(new Car(ModelName.FordEcoSport5,(byte)5));
        dataStorage.addCar(new Car(ModelName.Toyoto7,(byte)7));
        dataStorage.addCar(new Car(ModelName.Hyundai1204,(byte)4));
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

          }catch (DrivingRatingException | SeatingRatingException e){
              System.out.println(e.getMessage());
          }


            try {
                FeedbackReport[] reports = dataStorage.getAllFeedback();
                for(FeedbackReport feedbackReport : reports){
                    System.out.println(feedbackReport);
                }
            }catch(AverageComputationException e){
                System.out.println(e.getMessage());
            }


    }
}
