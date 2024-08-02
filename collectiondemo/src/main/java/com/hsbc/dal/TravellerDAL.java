package com.hsbc.dal;

import com.hsbc.models.Traveller;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface TravellerDAL {

    boolean addTraveller(Traveller traveller) throws IOException;
    Traveller[] getTravellers(int size) throws IOException, ClassNotFoundException;
    void close() throws IOException;
}
