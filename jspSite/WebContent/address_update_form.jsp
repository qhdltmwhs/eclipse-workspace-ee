<%@page import="com.itwill.address.Address"%>
<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String noStr=request.getParameter("no");
	if(noStr==null|| noStr.equals("")){
		response.sendRedirect("address_main.jsp");
		return;
	}
	AddressService addressService=new AddressService();
	Address address=addressService.selectByNo(Integer.parseInt(noStr));
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>[김경호님 주소록 수정폼]</h1><hr>
<hr>
	<div>
		<a href='address_list.jsp'>[주소록리스트]</a>
	</div>
	<form method="post" action="address_update_action.jsp">
		번호----<input type="hidden" name="no" value="<%=address.getNo()%>" ><br> 
		아이디--<input type="text" name="id" value="<%=address.getId() %>"><br> 
		이름----<input type="text" name="name" value="<%=address.getName()%>"><br> 
		전화번호<input type="text" name="phone" value="<%=address.getPhone()%>"><br> 
		주소----<input type="text" name="address" value="<%=address.getAddress()%>"><br> 
		<input type="submit" value="주소록수정">
		<input type="reset" value="주소록수정폼지우기">
	</form>
</body>
</html>
