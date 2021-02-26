package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class Add extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String xStr = request.getParameter("x");
		String yStr = request.getParameter("y");
		int	xInt = 0;
		int	yInt = 0;
		
		if(!xStr.equals("")) {
			xInt = Integer.parseInt(xStr);
		}
		if(!yStr.equals("")) {
			yInt = Integer.parseInt(yStr);
		}
		int result = xInt + yInt;		
		PrintWriter out = response.getWriter();
		out.printf("result is %d\n", result);
	}

}
