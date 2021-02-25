<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String loginId=(String)session.getAttribute("loginId");
	if(loginId==null){
		response.sendRedirect("7-2.default_session_login_form.jsp");
		return;
	}
%>
<%
/*
세션객체 무효화
서버세션ID날리기~! (클라이언트의 세센ID는 브라우저의 메모리상에  살아있음)
Invalidates this session then unbinds any objects bound to it. 
*/
session.invalidate();
%>
<h1>로그아웃</h1>
<div>
	<%=loginId %> 님 안녕히가세요!!! 
</div>
<div>
	<a href="7-2.default_session_login_form.jsp">로그인</a>
	<a href="7-2.default_session_use1.jsp">회원전용페이지1</a>
	<a href="7-2.default_session_use2.jsp">회원전용페이지2</a>
</div>