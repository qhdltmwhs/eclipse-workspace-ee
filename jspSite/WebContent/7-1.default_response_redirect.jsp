<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String msg1="아이디가 필요합니다";
    String msg2="패쓰워드가 일치하지않습니다.";
    String url="2.gugudan.jsp";
    msg1=URLEncoder.encode(msg1, "UTF-8");
    msg2=URLEncoder.encode(msg2, "UTF-8");
    url=URLEncoder.encode(url, "UTF-8");
    
	response.sendRedirect("7-1.default_response_redirected.jsp?msg1="+msg1+"&msg2="+msg2+"&url="+url);
%>