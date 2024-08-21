package com.hsbc.hospitalmanagementapi.services;

import com.hsbc.hospitalmanagementapi.models.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private RestClient restClient;
    @Value("${userUrl}")
    private String userUrl;
    @Override
    public User addUser(String name, String job) {
        JSONObject jo = new JSONObject();
        jo.put("name", name);
        jo.put("job", job);


        restClient.post()
                .uri(userUrl)
                .contentType(APPLICATION_JSON)
                .body(jo)
                .retrieve()
                .toBodilessEntity();
    }
}
