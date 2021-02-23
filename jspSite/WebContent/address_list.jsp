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
		<li><a href='address_detail.jsp?no=<%=address.getNo()%>'>[<%=address.getNo()%>]<%=address.getId() %></a></li>
		<%}%>
	</ul>
</div>
</body>
</html>		