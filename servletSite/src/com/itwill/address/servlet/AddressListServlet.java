package com.itwill.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressDao;

/**
 * Servlet implementation class AddressListServlet
 */
@WebServlet("/AddressListServlet")
public class AddressListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try {
			AddressDao addressDao=new AddressDao();
			List<Address> addressList = addressDao.selectAll();
			/*
			for (Address address : addressList) {
				out.println(address);
			}
			*/
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Insert title here</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>[주소록리스트]</h1><hr>");
			out.println("<div>");
			out.println("	<a href='address_insert_form.do'>[주소록쓰기폼]</a>");
			out.println("</div>");
			out.println("<div>");
			out.println("	<ul>");
			for (Address address : addressList) {
				out.println("		<li><a href='address_detail.do?no="+address.getNo()+"'>["+address.getNo()+"]"+address.getId()+"</a></li>");
			}
			out.println("	</ul>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}