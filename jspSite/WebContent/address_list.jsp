<%@page import="com.itwill.address.Address"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
AddressService addressService=new AddressService();
ArrayList<Address> addressList=addressService.selectAll();
%>    
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
</head>
<body>
<h1>[주소록리스트]</h1><hr>
<div>
	<a href='address_insert_form.jsp'>[주소록쓰기폼]</a>
</div>
<div>
	<ul>
		<%for(Address address:addressList){ %>
		<li><a href='address_detail.jsp?no=1'>[<%=address.getNo()%>]<%=address.getId() %></a></li>
		<%}%>
	</ul>
</div>
</body>
</html>		
<!-- 
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<meta charset='UTF-8'>");
out.println("<title>Insert title here</title>");
out.println("</head>");
out.println("<body>");
out.println("<h1>[주소록리스트]</h1><hr>");
out.println("<div>");
out.println("	<a href='address_insert_form.do'>[주소록쓰기폼]</a>");
out.println("</div>");
out.println("<div>");
out.println("	<ul>");
out.println("		<li><a href='address_detail.do?no=1'>[1]guard</a></li>");
out.println("		<li><a href='address_detail.do?no=2'>[2]abcdf</a></li>");
out.println("	</ul>");
out.println("</div>");
out.println("</body>");
out.println("</html>");
 -->