package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Simple Calculator</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Simple Calculator</h1>");
        out.println("<form action='CalculatorServlet' method='post'>");
        out.println("<label>First Number:</label>");
        out.println("<input type='number' name='num1' required><br><br>");
        out.println("<label>Second Number:</label>");
        out.println("<input type='number' name='num2' required><br><br>");
        out.println("<label>Operation:</label>");
        out.println("<select name='operation'>");
        out.println("<option value='add'>Add</option>");
        out.println("<option value='subtract'>Subtract</option>");
        out.println("<option value='multiply'>Multiply</option>");
        out.println("<option value='divide'>Divide</option>");
        out.println("</select><br><br>");
        out.println("<input type='submit' value='Calculate'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("operation");
        double result = 0;
        boolean validOperation = true;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    validOperation = false;
                    out.println("<h2>Cannot divide by zero!</h2>");
                }
                break;
            default:
                validOperation = false;
                out.println("<h2>Invalid Operation!</h2>");
                break;
        }

        if (validOperation) {
            out.println("<h2>Result: " + result + "</h2>");
        }

        out.println("<br><a href='CalculatorServlet'>Back to Calculator</a>");
        out.close();
    }
}
