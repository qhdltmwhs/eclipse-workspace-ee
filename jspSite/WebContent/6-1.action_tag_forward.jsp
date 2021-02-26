<%@page import="com.itwill.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("6-1.action_tag_forward.jsp");
	/*
	6-1.action_forwarded.jsp에 전달할데이타 넣기
	*/
	String id="guard";
	String pass="1111";
	String msg="존재하지않는 아이디 입니다.";
	Address address=new Address(1,"aaa","에이","234","서울");
	
	request.setAttribute("id", id);
	request.setAttribute("pass", pass);
	request.setAttribute("msg", msg);
	request.setAttribute("address", address);
	/*
	RequestDispatcher rd=
			request.getRequestDispatcher("6-1.action_tag_forwarded.jsp");
	rd.forward(request, response);
	*/
%>
<jsp:forward page="6-1.action_tag_forwarded.jsp"/>
