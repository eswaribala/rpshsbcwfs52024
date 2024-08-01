package com.retail.dal;

import com.retail.dtos.FeedbackReport;
import com.retail.entities.Car;
import com.retail.entities.CustomerFeedback;
import com.retail.exceptions.DrivingRatingException;
import com.retail.exceptions.SeatingRatingException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataStorage {

    boolean addCar(Car car) throws IOException;
    boolean addCustomerFeedback(CustomerFeedback customerFeedback) throws DrivingRatingException, SeatingRatingException, IOException;

    Car[] getAllCars() throws IOException;
    FeedbackReport[] getAllFeedback() throws IOException;

}
