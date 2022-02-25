package ch6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 자바스크립트를 이용해서 서블릿 요청하기

// http://localhost:9090/servlettest/login
@WebServlet("/loginjs")
public class JS_LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청자로부터 사용자가 입력한 id, pw추출
		String id =request.getParameter("id"); // getParameter: input태그의 name속성의 값. 서버쪽에서는 name속성을 읽어온다.
		String pw = request.getParameter("pw"); 
		String role = request.getParameter("role"); 

		// 처리
		// 결과 응답 내용
		response.setContentType("text/html;charset=utf-8"); // setContentType: 지금 내가 보낼 내용이 html 문서임을 알려주는 것. html의 meta태그 내 utf-8지정하는 것처럼.
		PrintWriter out = response.getWriter(); // 서버 출력 = 클라이언트로 전송. 응답결과는 PrintWriter타입이다. 
		out.println("<h3 style ='color:green'> 입력하신 아이디는" + id + "이고 암호는 " 
		+ pw + "입니다. <h3>");
		out.println("<h3>"+ role +"자격으로 로그인되셨습니다.<h3>");
		
		response.getWriter().append("<p>append입니다</p>"); // append함수: println메서드와 같은 역할
		
	}

}
