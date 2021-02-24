<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	1. 요청객체로부터 클라이언트가 전송한 쿠키객체들얻기
	*/
	Cookie[] cookies= request.getCookies();
	String oldSearchKeyword="";
	String ip="";
	if(cookies!=null){
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("searchKeyword")){
				oldSearchKeyword = cookie.getValue();
				oldSearchKeyword=URLDecoder.decode(oldSearchKeyword,"UTF-8");
			}
			if(cookie.getName().equals("ip")){
				ip = cookie.getValue();
			}
			
		}
	}
	System.out.println(">>클라이언트가 전송한 쿠키정보:"+oldSearchKeyword+"--> ip:"+ip);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키읽기</h1><hr/>
	<form action="7-0.cookie_create.jsp">
		검색어:<input type="text" name="searchKeyword" 
			placeholder="검색어를 입력하세요" value="<%=oldSearchKeyword%>">
		<input type="submit" value="검색">
	</form>
</body>
</html>
