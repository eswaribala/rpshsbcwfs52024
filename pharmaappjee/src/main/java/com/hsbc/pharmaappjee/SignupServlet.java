package com.hsbc.pharmaappjee;

import com.google.gson.Gson;
import com.hsbc.pharmaappjee.models.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import netscape.javascript.JSObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "signUpServlet", value = "/signup-servlet", asyncSupported = true)
public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson=new Gson();

        System.out.println("received......");
        InputStream inputStream=req.getInputStream();
        BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
        StringBuilder stringBuilder=new StringBuilder();
        int value=0;
        while((value=bufferedInputStream.read())>0){
            stringBuilder.append((char)value);
        }
        System.out.println(stringBuilder);

        Customer customer=gson.fromJson(String.valueOf(stringBuilder), Customer.class);
        System.out.println(customer);
        PrintWriter out= resp.getWriter();
        resp.setContentType("text/html");
        out.println(stringBuilder);

        /*
        String name=req.getParameter("name");
        String dob=req.getParameter("dob");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        */

    }
}
