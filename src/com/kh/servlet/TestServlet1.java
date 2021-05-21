package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpServletRequest.getParameter() : 뷰에서 name(파라미터)에 담아 보낸 데이터를 String으로 받아오는 메소드
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		// HttpServletRequest.getParameterValues(String name) : 뷰에서 name(파라미터)에 담아 보낸 데이터가 여러개 일 때 String[]으로 담아오는 메소드
		String[] food = request.getParameterValues("food");
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		System.out.println("food : " + Arrays.toString(food));
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인 정보 출력화면</title>");
		out.println("<style>");
		out.println("h2{color: red;}");
		out.println(".info{font-weight: bold;}");
		out.println("#name{color:orange;}");
		out.println("#gender{color:yellow; background: black;}");
		out.println("#age{color:green;}");
		out.println("#city{color:blue;}");
		out.println("#height{color:navy;}");
		out.println("#food{color:purple;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인 취향 테스트 결과</h2>");
		out.println("<span class='info' id='name'>" + name + "</span>님은 ");
		out.printf("<span class='info' id='age'>%s</span>이시며, ", age);
		out.printf("<span class='info' id='city'>%s</span>에 사는, ", city);
		out.printf("<span class='info' id='height'>%s</span>cm인, ", height);
		out.printf("<span class='info' id='gender'>%s</span>입니다, ", gender);
		out.printf("좋아하는 음식은<span class='info' id='food'>");
		for(int i = 0; i < food.length; i++) {
			if(i == 0) {
				out.printf("%s", food[i]);
			}else {
				out.printf(",%s", food[i]);
			}
		}
		out.println("</span>입니다.");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
		
		
	}
}
