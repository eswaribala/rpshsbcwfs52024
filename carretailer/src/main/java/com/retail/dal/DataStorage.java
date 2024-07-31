package com.retail.dal;

import com.retail.dtos.FeedbackReport;
import com.retail.entities.Car;
import com.retail.entities.CustomerFeedback;
import com.retail.exceptions.DrivingRatingException;
import com.retail.exceptions.SeatingRatingException;

public interface DataStorage {

    boolean addCar(Car car);
    boolean addCustomerFeedback(CustomerFeedback customerFeedback) throws DrivingRatingException, SeatingRatingException;

    Car[] getAllCars();
    FeedbackReport[] getAllFeedback();

}
