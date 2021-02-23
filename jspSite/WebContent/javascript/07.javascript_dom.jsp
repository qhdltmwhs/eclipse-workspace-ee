<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function access_form(){
		var formE = document.getElementById("f");
		formE.id.value='guard';
		formE.irum.value='가아드';
		formE.style.borderStyle='dashed';
		formE.style.borderColor='orange';
		formE.style.color='blue';
		/*
		formE.action='test.jsp';
		formE.method='POST';
		formE.submit();
		*/
	}
	function access_div(){
		var div1E = document.getElementById('div1');
		var div1Content = div1.innerHTML;
		alert("div1내용:"+div1Content);
		div1E.innerHTML='';
		div1E.innerHTML+="<ol>";
		div1E.innerHTML+="<li>김태희</li>";
		div1E.innerHTML+="<li>고소영</li>";
		div1E.innerHTML+="</ol>";
		div1E.innerHTML+="<img src='penguin3.gif'>";
		div1E.innerHTML+="<img src='penguin2.gif'>";
		div1E.innerHTML+="<img src='penguin1.gif'>";
		
	}
	var count=0;
	function access_img(){
		count=count%3;
		count++;
		document.getElementById('img1').src='penguin'+count+'.gif';
	}
	function form_display(){
		var f = document.getElementById('f');
		/*
		if(f.style.display=='block'){
			f.style.display='none';
		}else{
			f.style.display='block';
		}
		*/
		if(f.style.visibility='visible'){
			f.style.visibility='hidden';
		}else{
			f.style.visibility='visible';	
		}
	}
</script>

</head>
<body>
<h1 onmouseover="form_display();"> javascript dom[document object model]</h1><hr>
<form action="" name='f' id='f'>
	아이디:<input type="text" name="id" id="id"><br>
	이  름:<input type="text" name="irum" id="irum"><br>
</form>
<div id="div1">
	div1 content
</div>
<div>
	<img id="img1" width="100" height="100" src='penguin1.gif'/>
	<span id="span1">span1 content</span>
</div>

<div>
	<input type="button" value="access form" onclick="access_form();">
	<input type="button" value="access div" onclick="access_div();">
	<input type="button" value="access img" onclick="access_img();">
	<input type="button" value="form display" onclick="form_display();">
</div>

</body>
</html>