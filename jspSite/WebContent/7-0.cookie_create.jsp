<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	/*
		1.Cookie객체생성
	*/
	Cookie cook1=new Cookie("id","xxxx");
	Cookie cook2=new Cookie("name","KIM");
	Cookie cook3=new Cookie("visitCount","45");
	Cookie cook4=new Cookie("showPopup","true");
	Cookie cook5=new Cookie("sessionId",(int)(Math.random()*123432423)+"");
	/*
	    2.쿠키객체설정(setMaxAge)
	       - 쿠키의유효기간설정(파일로저장)
	       - 쿠키의유효기간설정안하면(메모리에저장)
	 */
	
	/*
		3.응답객체에 쿠키추가
	*/
	response.addCookie(cook1);
	response.addCookie(cook2);
	response.addCookie(cook3);
	response.addCookie(cook4);
	response.addCookie(cook5);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>검색결과[쿠키생성]</h1><hr>
<div>니안에 쿠키있다.</div>
<ol>
	<li> 검색결과</li>
	<li> 검색결과</li>
	<li> 검색결과</li>
	<li> 검색결과</li>
	<li> 검색결과</li>
	<li> 검색결과</li>
	<li> 검색결과</li>
	<li> 검색결과</li>
</ol>
<div>
	<a href='7-0.cookie_search.jsp'>다시검색[쿠키읽기]</a>
	<a href='7-0.cookie_delete.jsp'>쿠키삭제</a>
</div>
</body>
</html>















