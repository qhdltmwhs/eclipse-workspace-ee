<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	 * 1.파라메타바끼
	  	아이디:<input type="text" name="id">
		패에쓰:<input type="password" name="pass">
	 */
	
	
	/*
	 * 2.업무실행(DB)
	 *  id |pass
	 *  ---------
	 *  xxxx|1111
	 *  yyyy|2222
	 */
	 
	/*
	 * 3.클라이언트로 결과전송
	 */
%> 
<h1>GET로그인결과</h1><hr/>
<h3>xxxx님 로그인성공</h3>
<a href='index.jsp'>메인으로</a>
<!-- 
<h1>GET로그인결과</h1><hr/>
<h3> zzzz 님 로그인실패</h3>
<a href='4.login_get_form.jsp'>다시로그인</a>
 -->
