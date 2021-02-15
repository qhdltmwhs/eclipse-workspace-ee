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
@WebServlet("/HelloServlet3")
public class HelloServlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-->"+ request.getRemoteAddr()+"님 요청하셨군요");
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int no=(int)(10* Math.random())+1;
		for(int i=0;i<no;i++) {
			out.println(request.getRemoteAddr()+"님 HelloServlet!!![java]"+(i+1));
		}
		System.out.println("-->"+ request.getRemoteAddr()+"님 에게 응답합니다[서비스]");
		
	}
}