/**
 * 
 */
function onload_id_focus(){
	console.log("form id:"+window.document.getElementById("joinFrm"));
	document.getElementById("joinFrm").focus();
}
function join_form_submit_button(){
	var id=document.getElementById("id").value;
	if(is_null(id)){
		alert('아이디를 입력하세요');
		document.getElementById('id').focus();
		return false;
	}
	var password=document.getElementById('password').value;
	if(password==null || password==''){
		alert('패쓰워드를 입력하세요');
		document.getElementById('password').focus();
		return false;
	}
	var repassword=document.getElementById('repassword').value;
	if(repassword==null || repassword==''){
		alert('패쓰워드확인을 입력하세요');
		document.getElementById('repassword').focus();
		return false;
	}
	var name=document.getElementById('name').value;
	if(name==null || name==''){
		alert('이름을 입력하세요');
		document.getElementById('name').focus();
		return false;
	}
	var address=document.getElementById('address').value;
	if(address==null || address==''){
		alert('주소를 입력하세요');
		document.getElementById('address').focus();
		return false;
	}
	if(!is_same(password,repassword)){
		alert('패쓰워드와패쓰워드확인은 일치하여야합니다.');
		document.getElementById('password').select();
		return false;
	}
	/*
	1.아이디는 5~10자여야한다
	2.영문알파벳대문자,소문자,숫자만 가능
	3.숫자로 시작할수없다
	*/
	

	return true;
}
function join_form_button(){
	var id=document.getElementById("id").value;
	if(id==null || id==''){
		alert('아이디를 입력하세요');
		document.getElementById('id').focus();
		return;
	}
	var password=document.getElementById('password').value;
	if(password==null || password==''){
		alert('패쓰워드를 입력하세요');
		document.getElementById('password').focus();
		return;
	}
	var repassword=document.getElementById('repassword').value;
	if(repassword==null || repassword==''){
		alert('패쓰워드확인을 입력하세요');
		document.getElementById('repassword').focus();
		return;
	}
	var name=document.getElementById('name').value;
	if(name==null || name==''){
		alert('이름을 입력하세요');
		document.getElementById('name').focus();
		return;
	}
	var address=document.getElementById('address').value;
	if(address==null || address==''){
		alert('주소를 입력하세요');
		document.getElementById('address').focus();
		return;
	}
	if(password!=repassword){
		alert('패쓰워드와패쓰워드확인은 일치하여야합니다.');
		document.getElementById('password').select();
		return;
	}
	document.getElementById('joinFrm').action='../4.join.jsp';
	document.getElementById('joinFrm').method='post';
	document.getElementById('joinFrm').submit();
}