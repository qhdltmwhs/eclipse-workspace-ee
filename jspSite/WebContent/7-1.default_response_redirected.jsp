<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg1=request.getParameter("msg1");
	String msg2=request.getParameter("msg2");
	String url=request.getParameter("url");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>7-1.default_response_redirected.jsp</h2><hr>
<p>7-1.default_response_redirect.jsp로부터 전달된데이타[파라메타]</p>
msg1:<%=msg1 %><br>
msg2:<%=msg2 %><br>
url:<%=url %><br>
</body>
</html>