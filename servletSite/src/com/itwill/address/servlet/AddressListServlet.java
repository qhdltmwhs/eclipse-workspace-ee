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
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try {
			AddressDao addressDao=new AddressDao();
			List<Address> addressList = addressDao.selectAll();
			for (Address address : addressList) {
				out.println(address);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}