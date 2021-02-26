<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@page import="jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	
	try{
		request.setCharacterEncoding("UTF-8");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		UserService userService = new UserService();
		String sUserId = (String)session.getAttribute("sUserId");
		User updateUser = new User(sUserId,password,name,email);
		int row = userService.update(updateUser);
		User user = userService.findUser(sUserId);
		session.setAttribute("sUser",user);
		response.sendRedirect("user_view_myinfo.jsp");
	
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");
	}
%>