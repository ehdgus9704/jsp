package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet4 extends HttpServlet{
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String age = request.getParameter("age");
	String city = request.getParameter("city");
	String height = request.getParameter("height");
	String[] food = request.getParameterValues("food");
	
//	System.out.println("name : " + name);
//	System.out.println("gender : " + gender);
//	System.out.println("age : " + age);
//	System.out.println("city : " + city);
	//System.out.println("height : " + height);
	//System.out.println("food : " + Arrays.toString(food));
	
	String recommendation = null;
	switch(age) {
	case "10대 미만": recommendation = "현금"; break;
	case "10대": recommendation = "more현금"; break;
	case "20대": recommendation = "프로그래밍 교재"; break;
	case "30대": recommendation = "유럽여행"; break;
	case "40대": recommendation = "코인"; break;
	case "50대": recommendation = "황혼의 동반자"; break;
	}
	
//	response.setContentType("text/html; charset=UTF-8");
//	PrintWriter out = response.getWriter();
//	out.println("<html>");
//	out.println("<head>");
//	out.println("<title>개인 정보 출력화면</title>");
//	out.println("<style>");
	//out.println("h2{color: red;}");
//	out.println(".info{font-weight: bold;}");
//	out.println("#name{color:orange;}");
//	out.println("#gender{color:yellow; background: black;}");
//	out.println("#age{color:green;}");
//	out.println("#city{color:blue;}");
//	out.println("#height{color:navy;}");
//	out.println("#food{color:purple;}");
//	out.println("</style>");
//	out.println("</head>");
//	out.println("<body>");
//	out.println("<h2>개인 취향 테스트 결과(POST)</h2>");
//	out.println("<span class='info' id='name'>" + name + "</span>님은 ");
//	out.printf("<span class='info' id='age'>%s</span>이시며, ", age);
//	out.printf("<span class='info' id='city'>%s</span>에 사는, ", city);
//	out.printf("<span class='info' id='height'>%s</span>cm인, ", height);
//	out.printf("<span class='info' id='gender'>%s</span>입니다, ", gender);
//	out.printf("좋아하는 음식은<span class='info' id='food'>");
//	for(int i = 0; i < food.length; i++) {
	//	if(i == 0) {
	//		out.printf("%s", food[i]);
	//	}else {
	//		out.printf(",%s", food[i]);
	//	}
	//}
	//out.println("</span>입니다.");
//	out.println("<hr>");
//	out.println("<h3>" + age + "에 맞는 선물 추천</h3>");
//	out.println("'" + recommendation + "' 선물은 어떠신가요?");
//	out.println("</body>");
//	out.println("</html>");

	// HttpServletRequest.setAttribute(String name, object o) : 데이터를 name에 담아주는 역활
	request.setAttribute("name", name);
	request.setAttribute("gender", gender);
	request.setAttribute("age", age);
	request.setAttribute("city", city);
	request.setAttribute("height", height);
	request.setAttribute("food", String.join(",", food));
	request.setAttribute("recommendation", recommendation);
	
	RequestDispatcher view = request.getRequestDispatcher("servlet/testServlet4end.jsp");
	view.forward(request, response);
	// RequestDispatcher.forward(HttpServletRequest request, HttpServletRestonse response)
	// : 지정한 view에 담은 데이터를 전송하는 메소드
	// -> 데이터를 가지고 뷰에서 데이터를 볼 수 있게 해줌(데이터 유지o)
	//      ==> request객체와 response객체 유지
	// -> url이 변하지 않음
	// foward는 데이터가 유지되지만 sendRedirect는 데이터가 유지 되지 않는다

	// HttpServletResponse.sendRedirect()
	// : 지정한 view에 전송하는 메소드
	// -> 데이터를 가져가지 않고 단순히 뷰만 호출함(데이터 유지x)
	//     ==> request객체와 response객체 새롭게 생성
	// -> url이 변함
	
	//1. 회원 가입 			forward/ sendRedirect
	//2. 게시글 상세보기		forward
	//3. 게시글 삭제		sendRedirect
	}

}