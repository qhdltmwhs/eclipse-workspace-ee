<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>회원 인증</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function login_form_submit(f) {
		if(f.id.value==''){
			alert('아이디를 입력하세요');
			f.id.focus();
			return false;
		}
		if(f.pass.value==''){
			alert('패스워드를 입력하세요');
			f.pass.focus();
			return false;
		}
		f.action='7-2.default_session_login_action.jsp';
		f.method='POST'
		return true;
	}
	function load_focus(f) {
		f.id.focus();
	}
</script>
</head>
<body onload="load_focus(document.login);">
	<h3 align="center">◆◆◆ 회원 로그인 ◆◆◆</h3>
	<form name="login" onsubmit="return window.login_form_submit(document.login);">
		<table bgcolor="black" cellspacing="1" cellpadding="5" align="center">
			<tr>
				<th bgcolor="44ff44"><font size="2">아이디</font></th>
				<td bgcolor="white" width="170" align="center"><input
					type="text" size="20" name="id"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">비밀번호</font></th>
				<td bgcolor="white" width="170" align="center"><input
					type="password" size="20" name="pass"></td>
			</tr>
			<tr>
				<th colspan="2" bgcolor="ff8888">
					&nbsp;<input type="submit" value="로그인" class="TXTFLD"></th>
			</tr>
		</table>
	</form>


</body>
</html>
