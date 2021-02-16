package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServletRequestServlet
 */
@WebServlet("/request.do")
public class HttpServletRequestServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String contextPath = request.getContextPath();
		String method = request.getMethod();
		String requestURI = request.getRequestURI();
		String requestURL = request.getRequestURL().toString();
		String remoteAddress = request.getRemoteAddr();
		int remotePort = request.getRemotePort();
		/****************************
		  << query string >>
		       - 클라이언트가 서버로 요청시데이타를 전송하는방법
		       - 형식:name1=value1&name2=value2
		       ex> name=kim&phone=1234&address=kyunggi
		       
		    1.GET 요청방식 :  request.do?<< query string >>
		        ex> request.do?name=kim&phone=1234&address=kyunggi 
		        
		    2.POST요청방식 : 책에서 볼께요!!!!  
		 ****************************/
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		
		out.println("<h1>HttpServletRequest</h1><hr>");
		out.println("<ol>");
		out.println("<li>contextPath:"+contextPath+"</li>");
		out.println("<li>method:"+method+"</li>");
		out.println("<li>requestURI:"+requestURI+"</li>");
		out.println("<li>requestURL:"+requestURL+"</li>");
		out.println("<li>remoteAddress:"+remoteAddress+"</li>");
		out.println("<li>remotePort:"+remotePort+"</li>");
		out.println("<li>클라이언트가 전송한 파라메타값얻기</li>");
		out.println("<li>name parameter value:"+name+"</li>");
		out.println("<li>phone parameter value:"+phone+"</li>");
		out.println("<li>address parameter value:"+address+"</li>");
		
		out.println("</ol>");
		
	}

}