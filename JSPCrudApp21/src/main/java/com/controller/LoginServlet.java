package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Slogin;
import com.model.SloginService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter pw =  response.getWriter();
	    pw.print("Servlet Loded");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		SloginService ss= new SloginService();
        Slogin slogin = new Slogin();
		
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        slogin.setUsername(username);
        slogin.setPassword(password);       
        try {
            if (ss.loginMainpage(slogin)) {
                response.sendRedirect("dashboard.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Redirect to error.jsp if there is an exception
            response.sendRedirect("error.jsp");
        }
	}

}
