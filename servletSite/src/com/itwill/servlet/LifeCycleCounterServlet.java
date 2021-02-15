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
@WebServlet("/lifecycle.do")
public class LifeCycleCounterServlet extends HttpServlet {
	
	public LifeCycleCounterServlet() {
		System.out.println("0.LifeCycleCounterServlet 기본생성자호출:" + this);
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("1.init() 생성자 호출직후에 단한번호출[객체초기화, 리소스획득]");
	}
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("3.destroy() 메소드--->객체가 메모리에서 해제될때 호출[리소스해지]");
	}
	private int count = 0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2.service()메소드---> 클라이언트 요청시마다 호출---> 요청IP " +request.getRemoteAddr()+" ===> "+this);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		count++;
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("	<center>");
		out.println("		현재까지의 페이지뷰수 <font color=#0000FF> "+count+" </font> 번입니다");
		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
