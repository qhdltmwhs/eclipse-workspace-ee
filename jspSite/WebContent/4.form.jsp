<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" type="text/css" href='css/common.css'>
<link rel="stylesheet" type="text/css" href='css/member.css'>


<style type="text/css">
</style>

<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript">
	function init() {
		window.join.id.focus();
		window.join.gender[0].checked = false;
		window.join.gender[1].checked = false;

		window.join.hobby[0].checked = true;
		window.join.hobby[1].checked = true;
		window.join.hobby[2].checked = true;
		window.join.hobby[3].checked = true;
		
		window.join.job.options[0].selected = true;
	}
	function checkForm(f) {
		if(f.id.value==''){
			alert('아이디를 입력하세요')
			f.id.focus();
			return false;	
		}
		/*
		radio
		*/
		var genderCheck = false;
		for(var i=0;i<f.gender.length; i++) {
			if(f.gender[i].checked==true) {
				genderCheck = true;
				break;
			}
		}
		if(!genderCheck){
			alert('성별을 선택하세요');
			return false;
		}
		/*
		select
		*/
		if(f.job.selectedIndex==0){
			alert('직업을 선택하세요')
			f.job.focus();
			return false;
		}
		/*
		check
		*/
		if(!window.confirm('가입하실래요?')){
			return false;
		}
		
		return true;
	
	}
	
	
</script>
</head>
<body onload="init();">
	<h3 align="center">◆◆◆ 회원가입 ◆◆◆</h3>
	<form name="join" method="post" action="4.join.jsp" onsubmit="return checkForm(document.join);">
		<table id="jointbl" bgcolor="black" cellspacing="1" cellpadding="5"
			align="center">
			<tr id="first-tr">
				<th bgcolor="44ff44"><font size="2">아이디</font></th>
				<td bgcolor="white" width="300"><input type="text" size="10"
					name="id" class="TXTFLD"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">비밀번호</font></th>
				<td bgcolor="white" width="300"><input type="password"
					size="10" name="pass" class="TXTFLD1"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">비밀번호확인</font></th>
				<td bgcolor="white" width="300"><input type="password"
					size="10" name="repass" class="TXTFLD1"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">이름</font></th>
				<td bgcolor="white" width="300"><input type="text" size="10"
					name="name" class="TXTFLD"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">주소</font></th>
				<td bgcolor="white" width="300"><input type="text" size="30"
					name="addr" class="TXTFLD"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">성별</font></th>
				<td bgcolor="white" width="300"><input type="radio"
					name="gender" value="남자" checked="checked"><font size="2">남자</font> <input
					type="radio" name="gender" value="여자"><font
					size="2">여자</font></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">직업</font></th>
				<td bgcolor="white" width="300"><select name="job" size="1">
						<option value="직업을선택하세요"><font size="2">직업을선택하세요</font></option>
						<option value="학생"><font size="2">학생</font></option>
						<option value="주부"><font size="2">주부</font></option>
						<option value="회사원"><font size="2">회사원</font></option>
						<option value="기타"><font size="2">기타</font></option>
				</select></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">취미</font></th>
				<td bgcolor="white" width="300"><input type="checkbox"
					name="hobby" value="컴퓨터" checked><font size="2">컴퓨터</font>
					<input type="checkbox" name="hobby" value="낮잠"><font
					size="2">낮잠</font> <input type="checkbox" name="hobby" value="연애"><font
					size="2">연애</font> <input type="checkbox" name="hobby" value="운동" checked="checked"><font
					size="2">운동</font> <input type="checkbox" name="hobby" value="기타"><font
					size="2">기타</font></td>
			</tr>
			<tr bgcolor="ff8888">
				<td align="center" colspan="2"><input type="submit" value="가입"> <input
					type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<br>
	<%@ include file="5-6.directive_included_file.jspf"%>
	<%--
	<%@page contentType="text/html; charset=UTF-8"%>
	<hr width="800">
	<p align="center">
		<b><font size="3">Copyright (</font>c<font size="2">)..By <font
				color="#0000ff">Kimkyoungho.[김경호]</font> All rights reserved.
		</font></b>
	</p>
	
	 --%>
</body>
</html>