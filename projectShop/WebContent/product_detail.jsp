<%@page import="com.itwill.shop.product.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String p_noStr = request.getParameter("p_no");
	if(p_noStr==null|| p_noStr.equals("")){
		response.sendRedirect("product_list.jsp");
		return;
	}
	ProductService productService;
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<style type="text/css" media="screen">
</style>
<script type="text/javascript">
	function jumun_create_form() {
		if (true) {
			alert('로그인 하세요');
			location.href = 'user_login_form.jsp';
		} else {
			document.buyFrm.method = 'POST';
			document.buyFrm.action = 'shop_jumun_create_form.jsp';
			document.buyFrm.submit();
		}
	}
	function productList() {
		location.href = 'shop_product_list.jsp';
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->

			<h1>
				<a href="">WEB SAMPLE SITE</a>
			</h1>

			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->

			<script type="text/javascript">
				function login_message() {
					alert('로그인하세요');
					location.href = 'user_login_form.jsp';
				}
			</script>
			<p>
				<strong>메 뉴</strong>
			</p>
			<ul>


				<li><a href="user_write_form.jsp">회원가입</a></li>
				<li><a href="user_login_form.jsp">로그인</a></li>


				<li><a href="shop_product_list.jsp">쇼핑몰</a></li>


				<li><a href="javascript:login_message();">장바구니</a></li>

			</ul>

			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>쇼핑몰 -
											상품상세보기</b></td>
								</tr>
							</table> <!-- 
							<form name="f" method="post">
							-->
							<table style="margin-left: 10px" border=0 width=80% height=376
								align=center>
								<tr valign=bottom>
									<td width=30% align=center class=t1><font size=2
										color=#0000FF><b>주문량</b></font></td>
									<td width=40% align=center class=t1><font size=2
										color=#0000FF><b>멍멍이 이름</b></font></td>
									<td width=30% align=center class=t1><font size=2
										color=#0000FF><b>멍멍이 소개</b></font></td>
								</tr>
								<tr width=100%>
									<td colspan=3 height=5><hr color=#556b2f></td>
								</tr>
								<tr width=100%>
									<td width=30% height=200 align=center class=t1>
										<form method="post" action="shop_add_cart.jsp">
											수량 : <input type=text name="cart_qty" value=1 size=4
												class=TXTFLD> 마리 <br /> <br /> <input type=submit
												value=장바구니에담기 class=TXTFLD /> <input type="hidden"
												name=p_no value="1">
										</form>
									</td>
									<td width=40% height=200 align=center><img border=0
										src=image/bigle.gif width=120 height=200></td>
									<td width=30% height=200 class=t1>
										<ol type="disc">
											<li><b>견종 : 비글&nbsp;&nbsp;&nbsp;</b></li>
											<li><font color=#FF0000>가격 :
													550000&nbsp;&nbsp;&nbsp;</font></li>
											<li><font color=#0000FF>기타 상세 정보 등...&nbsp;&nbsp</font></li>
										</ol>
									</td>
								</tr>
								<tr>
									<td colSpan=3 height=21><hr color=#556b2f></td>
								</tr>
							</table> <!-- 
							</form>
							-->
							<form name="buyFrm">
								<input type="hidden" name="p_no" value="1"> <input
									type="hidden" name="p_qty" value="1"> <input
									type="hidden" name="buyType" value="direct">
							</form>

							<table border="0" cellpadding="0" cellspacing="1">
								<tr>
									<td align=center><input type="button" value="구매"
										onClick="jumun_create_form();"> &nbsp; <input
										type="button" value="계속쇼핑" onClick="productList();"></td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->

			<p align="center">Copyright (&copy;) By Java Class 5. All rights
				reserved.</p>

			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>