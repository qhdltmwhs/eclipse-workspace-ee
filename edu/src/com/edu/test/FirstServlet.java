package com.edu.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/*
 * 나: 내가 개발하는 서블릿
 * 아빠: HttpServlet
 * 할아버지: GenericServlet
 * 증조할아버지: Servlet
 * 모든 자바 클래스 조상: Object 
 */

@WebServlet("/hello2")
public class FirstServlet extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 실행됨!");	
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws
											ServletException, IOException {
		System.out.println("service() 실행됨!");
	}
	
}
