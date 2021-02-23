<%@page import="com.itwill.address.AddressService"%>
<%@page import="com.itwill.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
 0.요청객체 encoding설정
 1.파라메타 바끼(no,id,name,phone,address)
 3.파라메타데이타로 Address객체생성
 2.AddressService객체생성
 4.AddressService.update()메쏘드실행
 5.adress_view.jsp?no=23 로 redirection
*/
if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("address_main.jsp");
	return;
}
request.setCharacterEncoding("UTF-8");
String noStr=request.getParameter("no");
String id=request.getParameter("id");
String name=request.getParameter("name");
String phone=request.getParameter("phone");
String addr=request.getParameter("address");
Address updateAddress=new Address(Integer.parseInt(noStr),id,name,phone,addr);
AddressService addressService=new AddressService();
int row=addressService.updateByNo(updateAddress);
response.sendRedirect("address_detail.jsp?no="+noStr);
%>