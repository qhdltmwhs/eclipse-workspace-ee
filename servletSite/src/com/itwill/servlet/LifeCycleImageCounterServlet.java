package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleCounterServlet
 */
@WebServlet("/imagecounter.do")
public class LifeCycleImageCounterServlet extends HttpServlet {
	
	private int count = 0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2.service()메소드---> 클라이언트 요청시마다 호출---> 요청IP " +request.getRemoteAddr()+" ===> "+this);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		count++;
		String countStr = Integer.toString(count);
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("	<center>");
		out.println("		현재까지의 페이지뷰수 <font color=#0000FF> "+count+" </font> 번입니다");
		//out.println("		현재까지의 페이지뷰수 <img src='images/1.png'/><img src='images/2.png'/><img src='images/3.png'/> 번입니다");
		out.println("		현재까지의 페이지뷰수 ");
		for(int i=0; i<countStr.length(); i++) {
			
			char c = countStr.charAt(i);
			out.println("<img src='images/"+c+".png'/>");
		}
		out.println(" 번입니다");
		
		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
