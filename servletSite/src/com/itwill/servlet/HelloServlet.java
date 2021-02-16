package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(Thread.currentThread().getName()+" 스레드 ");
		response.setContentType("text/html;charset=UTF-8");//응답의헤더
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");//응답의 바디>>
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		int no=(int)(10* Math.random())+1;
		for(int i=0;i<no;i++) {
			out.println("<h3>Hello[안녕] Servlet!!![web dynamic resource]"+(i+1)+"</h3>");
			out.println("<hr>");
		}	
		out.println("</body>");
		out.println("</html>");//응답의 바디>>
		
		
	}
}