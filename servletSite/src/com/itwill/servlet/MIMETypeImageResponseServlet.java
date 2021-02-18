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
@WebServlet("/response_image.do")
public class MIMETypeImageResponseServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		/*
		 *  servletSite의 실제 경로
		 */
		ServletContext siteContext = this.getServletContext();
		String contextImageRealPath = siteContext.getRealPath("/images/image.jpg");
		System.out.println(contextImageRealPath);
		/*
		 * D:\JAVA_BACKEND\eclipse-workspace-ee\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\servletSite
		 */
		FileInputStream imageIn = new FileInputStream(contextImageRealPath);
		while(true) {
			int readByte = imageIn.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		imageIn.close();
	}

}
