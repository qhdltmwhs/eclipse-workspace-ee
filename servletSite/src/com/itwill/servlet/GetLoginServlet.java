package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetLoginServlet
 */
@WebServlet("/get_login.do")
public class GetLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청방식:"+request.getMethod());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		/*
		 * 1.요청시전동되는 파라메타받기
		 * 	  -파라메타의 이름은 input element의 name속성과 일치
		 * 		아이디:<input type="text" name="id"><br/>
		 *		패에쓰:<input type="password" name="pass"><br/><br/>
		 *	  -http://127.0.0.1/servletSite/get_login.do?id=guard&pass=1111	
		 */
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		if(id==null || pass==null || id.equals("") || pass.equals("")) {
			out.println("<h1>아이디, 패스워드를 입력하세요[GET]</h1><hr>");
			out.println("<a href='05-01.login_get.html'>로그인폼</a>");
			return;
		}
		
		/*
		 * 2.로그인업무실행(Service객체실행)
		 * 
		  id |pass
		  -------
		  xxx|111
		  yyy|222
		  -------
		 */			
		boolean isMember1 = id.equals("xxx") && pass.equals("1111");
		boolean isMember2= id.equals("yyy") && pass.equals("2222");
		out.println("<h1>GET 로그인결과</h1><hr>");
		if(isMember1 || isMember2) {
			//로그인성공
			out.println("<h3>"+id+"님 로그인성공</h3><hr>");
			out.println("<a href='index.html'>메인으로</a>");
		}else {
			//로그인실패
			out.println("<h3>"+id+"님 로그인실퐤</h3><hr>");
			out.println("<a href='05-01.login_get.html'>다시로그인</a>");
		}
	}

}
