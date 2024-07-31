package com.retail.dal;

import com.retail.dtos.FeedbackReport;
import com.retail.entities.Car;
import com.retail.entities.CustomerFeedback;
import com.retail.entities.ModelName;
import com.retail.exceptions.AverageComputationException;
import com.retail.exceptions.DrivingRatingException;
import com.retail.exceptions.SeatingRatingException;
import com.retail.exceptions.StorageException;

public class DataStorageImpl implements DataStorage{

    private Car[] cars;
    private CustomerFeedback[] customerFeedbacks;
    private FeedbackReport[] feedbackReports;
    private static int carPos=0;
    private static int feedbackPos=0;

    private static int accToyato=0,tCount=0;
    private static int accHyundai=0,hCount=0;
    private static int accFord=0,fCount=0;
    public  DataStorageImpl(int noOfCars, int noOfCustomers){
        cars=new Car[noOfCars];
        customerFeedbacks=new CustomerFeedback[noOfCustomers];
        feedbackReports=new FeedbackReport[ModelName.values().length];
    }


    @Override
    public boolean addCar(Car car) {
        if(carPos< cars.length){
            cars[carPos]=car;
            carPos++;
        }
        return true;
    }

    @Override
    public boolean addCustomerFeedback(CustomerFeedback customerFeedback) throws DrivingRatingException,SeatingRatingException {
        if(feedbackPos< customerFeedbacks.length){
            if ((customerFeedback.getDrivingComfortRating()>0)&&(customerFeedback.getDrivingComfortRating()<=5) ){
                if ((customerFeedback.getSeatComfortRating()>0)&&(customerFeedback.getSeatComfortRating()<=5) ) {
                    customerFeedbacks[feedbackPos]=customerFeedback;
                    feedbackPos++;
                }else
                {
                    throw new SeatingRatingException("Seating Comfort Rating not in range");
                }
                }else {
                throw new DrivingRatingException("Driving Comfort Rating not in range");
            }

        }else{
            throw new StorageException("Exceeded the size");
        }
        return true;
    }

    @Override
    public Car[] getAllCars() {
        return cars;
    }

    @Override
    public FeedbackReport[] getAllFeedback() {

        for(CustomerFeedback customerFeedback:customerFeedbacks){

            switch (customerFeedback.getModelName()){

               case FordEcoSport5:
                    fCount++;
                    accFord=accFord+(customerFeedback.getSeatComfortRating()+customerFeedback.getDrivingComfortRating())/2;
                    break;

                case Toyoto7:
                    tCount++;
                    accToyato=accToyato+(customerFeedback.getSeatComfortRating()+customerFeedback.getDrivingComfortRating())/2;
                    break;

                case Hyundai1204:
                    hCount++;
                    accHyundai=accHyundai+(customerFeedback.getSeatComfortRating()+customerFeedback.getDrivingComfortRating())/2;
                    break;

            }

        }
        float tAverage=0.0f;
        float hAverage=0.0f;
        float fAverage=0.0f;

           for (int i = 0; i < ModelName.values().length; i++) {
               if (i == 0) {
                  try {
                      tAverage = accToyato / tCount;
                      feedbackReports[i] = new FeedbackReport(ModelName.Toyoto7, 7, tAverage);
                  }catch(ArithmeticException e){

                     throw new AverageComputationException("Average Computation Failed due to o cars ");
                  }
               }
               if (i == 1) {
                   fAverage = accFord / fCount;
                   feedbackReports[i] = new FeedbackReport(ModelName.FordEcoSport5, 5, fAverage);
               }
               if (i == 2) {
                   hAverage = accHyundai / hCount;
                   feedbackReports[i] = new FeedbackReport(ModelName.Hyundai1204, 4, hAverage);
               }
           }




       return feedbackReports;
    }
}
