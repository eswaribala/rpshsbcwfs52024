package com.hsbc.hospitalmanagement.services;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CountryService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${countryUrl}")
    private String countryUrl;

    public List<String> getCountryNames() {

       ResponseEntity responseEntity =restTemplate.getForEntity(countryUrl,
               List.class);
       List<Object> countriesList= (List<Object>) responseEntity.getBody();
       List<String> countryNames=new ArrayList<>();
       JSONObject jsonObject=null;

       for(Object object : countriesList){
           jsonObject=new JSONObject((Map)object);
           //System.out.println(jsonObject.get("name"));
           countryNames.add(jsonObject.get("name").toString());
       }
        return countryNames;
    }




}
