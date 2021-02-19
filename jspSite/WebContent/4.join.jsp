<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP주석
	1.파라메타 받기
	2.서비스 메소드 호출(가입)
	3.응답
 --%>
 <!-- 
 	HTML주석
	1.파라메타 받기
	2.서비스 메소드 호출(가입)
	3.응답
  -->
 <%
 	if(request.getMethod().equalsIgnoreCase("GET")){
 		response.sendRedirect("4.form.jsp");
 		return;
 	}
 	
 
 	request.setCharacterEncoding("UTF-8");
 	String id =request.getParameter("id");
	String pass =request.getParameter("pass");
	String repass =request.getParameter("repass");
	String name =request.getParameter("name");
	String addr =request.getParameter("addr");
	String gender =request.getParameter("gender");
	String job =request.getParameter("job");
	String[] hobbies = request.getParameterValues("hobby");
	if(hobbies==null){
		hobbies = new String[0];
	}
 	
 	
 %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>가입결과</h1><hr>
<ol>
	<li>아이디:<%=id %></li>
	<li>패스워드:<%=pass %></li>
	<li>이름:<%=name %></li>
	<li>주소:<%=addr %></li>
	<li>직업:<%=job %></li>
	<%for(int i=0; i<hobbies.length; i++){ %>
		<li>취미:<%=hobbies[i]%></li>
	<%} %>
</ol>
</body>
</html>