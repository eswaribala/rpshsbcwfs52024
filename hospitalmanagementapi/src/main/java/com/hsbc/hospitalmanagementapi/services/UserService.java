package com.hsbc.hospitalmanagementapi.services;
import com.hsbc.hospitalmanagementapi.models.User;

import java.util.List;

public interface UserService {


    String addUser(String name, String job);
    String getAllUsers();

}
