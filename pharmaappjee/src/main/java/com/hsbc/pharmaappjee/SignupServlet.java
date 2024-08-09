package com.hsbc.pharmaappjee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "signUpServlet", value = "/signup-servlet")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out= resp.getWriter();
        resp.setContentType("text/html");
        out.println(req.getParameter("customer"));

        /*
        String name=req.getParameter("name");
        String dob=req.getParameter("dob");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        */

    }
}
