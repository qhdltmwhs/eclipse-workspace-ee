package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("05-03.form.html");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8"); //POST방식일때 요청시 인코딩해야함
		/*
		 * 1. 파라메타 받기
		 */
		String id =request.getParameter("id");
		String pass =request.getParameter("pass");
		String repass =request.getParameter("repass");
		String name =request.getParameter("name");
		String addr =request.getParameter("addr");
		String gender =request.getParameter("gender");
		String job =request.getParameter("job");
		String[] hobbies = request.getParameterValues("hobby");
		
		/*
		 * 2. Service객체 메소드 호출
		 */
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>회원 가입</title>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3 align=\"center\">◆◆◆ 회원가입결과◆◆◆</h3>");
		out.println("<form name=\"join\" method=\"POST\" action=\"join.do\">");
		out.println("<table bgcolor=\"black\" cellspacing=\"1\" cellpadding=\"5\" align=\"center\">");
		out.println("<tr>");
		out.println("<th  bgcolor=\"ff8888\">항목</th>");
		out.println("<td  bgcolor=\"ff8888\">입력값</td>");
		out.println("</tr>");
		out.println("<tr id=\"first-tr\">");
		out.println("<th bgcolor=\"44ff44\"><font size=\"2\">아이디</font></th>");
		out.println("<td bgcolor=\"white\" width=\"300\">"+id+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th bgcolor=\"44ff44\"><font size=\"2\">비밀번호</font></th>");
		out.println("<td bgcolor=\"white\" width=\"300\">"+pass+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th bgcolor=\"44ff44\"><font size=\"2\">이름</font></th>");
		out.println("<td bgcolor=\"white\" width=\"300\">"+repass+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th bgcolor=\"44ff44\"><font size=\"2\">주소</font></th>");
		out.println("<td bgcolor=\"white\" width=\"300\">"+addr+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th bgcolor=\"44ff44\"><font size=\"2\">성별</font></th>");
		out.println("<td bgcolor=\"white\" width=\"300\"><font size=\"2\">"+gender+"</font></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th bgcolor=\"44ff44\"><font size=\"2\">직업</font></th>");
		out.println("<td bgcolor=\"white\" width=\"300\">"+job+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th rowspan="+(hobbies.length+1)+" bgcolor=\"44ff44\"><font size=\"2\">취미</font></th>");
		for (String hobby : hobbies) {
			out.println("<td bgcolor=\"white\" width=\"300\">"+hobby+"</td>");	
			out.println("</tr>");
			//out.println("<tr>");
		}
		//out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		/*
		out.println("<td bgcolor=\"white\" width=\"300\">여행</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td bgcolor=\"white\" width=\"300\">독서</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td bgcolor=\"white\" width=\"300\">등산</td>");
		*/
		
		/*
		out.println("<h1>가입정보</h1><hr>");
		out.println("<ul>");
		out.println("<li>아이디:"+id+"</li>");
		out.println("<li>패스워:"+pass+"</li>");
		out.println("<li>리패스:"+repass+"</li>");
		out.println("<li>이름:"+name+"</li>");
		out.println("<li>주소:"+addr+"</li>");
		out.println("<li>성별:"+gender+"</li>");
		out.println("<li>직업:"+job+"</li>");
		for (String hobby : hobbies) {
			out.println("<li>취미:"+hobby+"</li>");
		}
		
		out.println("</ul>");
		*/
	}

}
