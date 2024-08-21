package com.hsbc.hospitalmanagementapi.services;
import com.hsbc.hospitalmanagementapi.models.User;

import java.util.List;

public interface UserService {


    User addUser(String name, String job);
    String getAllUsers();

}
