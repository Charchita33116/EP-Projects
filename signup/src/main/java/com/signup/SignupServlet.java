package com.signup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
// TODO Auto-generated method stub
 // Get form data from the request
 String firstName = request.getParameter("firstname");
 String lastName = request.getParameter("lastname");
 String email = request.getParameter("email");
 String phone = request.getParameter("phone");
 String address = request.getParameter("address");
 // Set the form data as request attributes
 request.setAttribute("firstname", firstName);
 request.setAttribute("lastname", lastName);
 request.setAttribute("email", email);
 request.setAttribute("phone", phone);
 request.setAttribute("address", address);
 // Forward the request to the result JSP page
 request.getRequestDispatcher("result.jsp").forward(request, response);
}
}