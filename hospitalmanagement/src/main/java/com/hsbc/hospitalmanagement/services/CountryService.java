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
import java.util.List;
import java.util.Map;

@Service
public class CountryService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${countryUrl}")
    private String countryUrl;

    public List<String> getCountryNames() throws NoSuchFieldException, IllegalAccessException {

       ResponseEntity responseEntity =restTemplate.getForEntity(countryUrl,
               String.class);
       parseString(responseEntity.getBody().toString());

        return null;

    }

    private void parseString(String response)
    {
        JSONParser parser = new JSONParser();
        String name="";
        try {

            // Put above JSON content to crunchify.txt file and change path location
            Object obj = parser.parse(response);
            JSONObject jsonObject = (JSONObject) obj;

            // JsonFlattener: A Java utility used to FLATTEN nested JSON objects
            String flattenedJson = JsonFlattener.flatten(jsonObject.toString());
            //log("\n=====Simple Flatten===== \n" + flattenedJson);

            Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(jsonObject.toString());
            name=(String) flattenedJsonMap.get("name");
            //log("\n=====Flatten As Map=====\n" + flattenedJson);
            // We are using Java8 forEach loop. More info: https://crunchify.com/?p=8047
            //flattenedJsonMap.forEach((k, v) -> log(k + " : " + v));

            // Unflatten it back to original JSON
            String nestedJson = JsonUnflattener.unflatten(flattenedJson);
            System.out.println("\n=====Unflatten it back to original JSON===== \n" + nestedJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
       // return token;

    }


}
