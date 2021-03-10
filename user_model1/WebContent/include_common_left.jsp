<%@page import="com.itwill.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sUserId = (String)session.getAttribute("sUserId");
	User sUser = (User)session.getAttribute("sUser");
%>    			
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	<%if(sUserId!=null && sUser!=null){ %>
		<li><a href=""><%=sUser.getName()%>님</a></li>
		<li><a href="user_logout_action.jsp">로그아웃</a></li>
		<li><a href='user_list.jsp'>회원리스트</a>
	<%}else{ %>	
		<li><a href="user_login_form.jsp">로그인</a></li>
		<li><a href="user_write_form.jsp">회원가입</a></li>
	<%} %>	
</ul>
