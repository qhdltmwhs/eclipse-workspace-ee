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
<h1>[<%=address.getName() %>님 주소록상세보기]</h1><hr>
<div>
	<a href='address_delete_action.jsp?no=<%=address.getNo()%>'><%=address.getName()%>님삭제[GET]</a>
	<!-- 
	<form action="" method="post">
		<input type="submit" value="김경호님삭제[POST]">
	</form>
	 -->
	<a href='address_update_form.jsp?no=<%=address.getNo()%>'>[<%=address.getName()%>님 주소록수정폼]</a>
	<a href='address_insert_form.jsp'>[주소록쓰기폼]</a>
	<a href='address_list.jsp'>[주소록리스트]</a>
</div>
<p>
	번호:<%=address.getNo()%><br>
	아이디:<%=address.getId()%><br>
	이름:<%=address.getName()%><br>
	전화:<%=address.getPhone()%><br>
	주소:<%=address.getAddress()%><br>
</p>
</body>
</html>