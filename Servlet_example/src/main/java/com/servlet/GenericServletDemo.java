package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletDemo extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html");
		Date d = new Date();
	    PrintWriter pw =  arg1.getWriter();
	        pw.print("<HTML>");
	        pw.print("<HEAD><TITLE> GenericServlet Demo </TITLE></HEAD>");
	        pw.print("<BODY>");
	        pw.print("<H2> Hii from Generic Servlet Class... </H2>");
	        pw.print("</BODY>");
	        pw.print("</HTML>");
		// TODO Auto-generated method stub
		
	}

}
