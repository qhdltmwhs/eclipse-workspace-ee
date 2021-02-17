package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServletResponseServlet
 */
@WebServlet("/response.do")
public class HttpServletResponseServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String cmd=request.getParameter("cmd");
		if(cmd==null) {
			response.sendRedirect("04.HttpServletResponse.html");
			return;
		}
		if(cmd.equals("1")) {
			/*
			<< 정상응답 >>
			   1. 응답라인 200
			   2. 응답헤더
			   3. 응답바디데이타 전송
			 */
			out.println("<h3>정상응답</h3><hr/>");
			
		}else if(cmd.equals("2")) {
			
			/*
			 << error응답 >>
			 * 1. 응답라인 4xx,5xx
			 * 2. 응답헤더
			 * 3. 응답바디데이타 없음(보낼수없음)
			 */
			//response.sendError(500);
			//response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
		}else if(cmd.equals("3")) {
			/*
			 << redirect >>
			   1. 응답라인 302
			   2. 응답헤더(redirection url)
			   3. 응답바디데이타 없음(보낼수없음)
			 */
			response.sendRedirect("04.HttpServletResponse.html");
			
		}
	}

}