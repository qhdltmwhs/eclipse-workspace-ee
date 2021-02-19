<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%-- 
<%@page import="java.util.*"%>
<%@page import="java.util.*,java.sql.*"%> 
--%>
<%@page import="com.itwill.address.AddressService"%>
<%@page import="com.itwill.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//com.itwill.address.Address address=new com.itwill.address.Address();
Address address = new Address();
AddressService addressService = new AddressService();
ArrayList arrayList = new ArrayList();
HashMap map = new HashMap();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>page 지시어 [import]</h1>
	<h2>형태:&lt;%@page import="com.itwill.Student"&gt;</h2>
	<hr />
	<%=address%><br>
	<%=addressService%><br>
	<%=arrayList%><br>
	<%=map%><br>
</body>
</html>
