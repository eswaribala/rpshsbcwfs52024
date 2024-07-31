package com.hsbc.dao;

import com.hsbc.models.Trainee;

public interface TraineeDao {

    Trainee addTrainee(Trainee trainee);
    Trainee[] getAllTrainees();
    Trainee getTrainee(long traineeId);
    boolean deleteTrainee(long traineeId);
    Trainee updateTrainee(long traineeId, String reportingLocation);

}
