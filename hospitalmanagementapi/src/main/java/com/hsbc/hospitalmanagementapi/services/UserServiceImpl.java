package com.hsbc.hospitalmanagementapi.services;

import com.hsbc.hospitalmanagementapi.models.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private RestClient restClient;
    @Value("${userUrl}")
    private String userUrl;
    @Value("${allUsersUrl}")
    private String allUsersUrl;
    @Override
    public String addUser(String name, String job) {
        User user=new User();
        user.setName(name);
        user.setJob(job);

       return restClient.post()
                .uri(userUrl)
                .body(user)
                .retrieve()
                .body(String.class);

    }

    @Override
    public String getAllUsers() {
        return restClient.get()
                .uri(allUsersUrl)
                .retrieve()
                .body(String.class);
    }
}
