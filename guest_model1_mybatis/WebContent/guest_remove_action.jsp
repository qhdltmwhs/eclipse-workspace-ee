<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("guest_main.jsp");
		return;
	}
	try{
		String guest_noStr = request.getParameter("guest_no");
		GuestService guestService=new GuestService();
		guestService.deleteGuest(Integer.parseInt(guest_noStr));
		response.sendRedirect("guest_list.jsp");
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("guest_error.jsp");
	}
%>