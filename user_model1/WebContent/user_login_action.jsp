<%@page import="com.itwill.user.User"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.exception.PasswordMismatchException"%>
<%@page import="com.itwill.user.exception.UserNotFoundException"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_login_form.jsp");
		return;
	}
	String userId = null;
	String password = null;
	try{
		userId=request.getParameter("userId");
		password=request.getParameter("password");
		UserService userService = new UserService();
		User loginUser = userService.login(userId, password);
		session.setAttribute("sUserId", userId);
		session.setAttribute("sUser", loginUser);
		response.sendRedirect("user_main.jsp");
	}catch(UserNotFoundException e){
		//case1		
		//response.sendRedirect("user_login_form.jsp?msg1="+URLEncoder.encode(e.getMessage(), "UTF-8"));
		request.setAttribute("msg1", e.getMessage());
		request.setAttribute("fuser", new User(userId,password,"",""));
		RequestDispatcher rd = request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
		
		
		
	}catch(PasswordMismatchException e){
		//response.sendRedirect("user_login_form.jsp?msg2="+URLEncoder.encode(e.getMessage(), "UTF-8"));
		request.setAttribute("msg2", e.getMessage());
		request.setAttribute("fuser", new User(userId,password,"",""));
		RequestDispatcher rd = request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
	
	
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");
	}
%>