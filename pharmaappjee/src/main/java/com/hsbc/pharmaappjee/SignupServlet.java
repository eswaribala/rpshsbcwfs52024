package com.hsbc.pharmaappjee;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hsbc.pharmaappjee.models.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import netscape.javascript.JSObject;

import java.io.*;

@WebServlet(name = "signUpServlet", value = "/signup-servlet", asyncSupported = true)
public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson=new Gson();

        System.out.println("received......");

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(req.getInputStream()));

        String json = "";
        if(bufferedReader != null){
            json = bufferedReader.readLine();
            System.out.println(json);
        }

        Customer customer=gson.fromJson(json,Customer.class);
        System.out.println(customer);
        PrintWriter out= resp.getWriter();
        resp.setContentType("text/html");
        out.println(customer);


    }
}
