package com.hsbc.dao;

import com.hsbc.models.Trainee;

public class TraineeFileImpl  implements TraineeDao{

    @Override
    public Trainee addTrainee(Trainee trainee) {
        return null;
    }

    @Override
    public Trainee[] getAllTrainees() {
        return new Trainee[0];
    }

    @Override
    public Trainee getTrainee(long traineeId) {
        return null;
    }

    @Override
    public boolean deleteTrainee(long traineeId) {
        return false;
    }

    @Override
    public Trainee updateTrainee(long traineeId, String reportingLocation) {
        return null;
    }
}
