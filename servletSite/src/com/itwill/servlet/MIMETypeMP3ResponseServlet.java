package com.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MIMETypeImageResponseServlet
 */
@WebServlet("/response_mp3.do")
public class MIMETypeMP3ResponseServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("audio/mpeg");
		OutputStream out=response.getOutputStream();
		/*
		 * servletSite의 실제경로
		 */
		ServletContext siteContext=this.getServletContext();
		String contextImageRealPath = siteContext.getRealPath("/images/a.mp3");
		System.out.println(contextImageRealPath);
		/*
		D:\JAVA_BACKEND\eclipse-workspace-ee\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\servletSite
		 */
		FileInputStream mp3In=new FileInputStream(contextImageRealPath);
		while(true) {
			int readByte = mp3In.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		mp3In.close();
		
		
	}

}