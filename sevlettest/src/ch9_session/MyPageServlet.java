package ch9_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage")
public class MyPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 서블릿이 입력받은 id, pw 가져오기
		
		
		// 요청된 브라우저의 세션 객체를 가져온다.
		HttpSession session = request.getSession();
		// 최초로 브라우저 열고 현재파일 요청: 세션이 없다 -> 세션 객체 새로 생성 
		// 브라우저 열어두고 다른 서블릿을 실행한 뒤 현재파일 요청 -> 세션이 이미 있는 상태. 이미 생성된 세션객체 가져온다.
		
		String session_id = "";
		if(session.getAttribute("session_id") != null) {
			session_id = (String)session.getAttribute("session_id");
		}
		else {			
			session_id = "로그인 먼저";
		}
		
		
		// 브라우저 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(session_id+"회원님 환영합니다.");
	}

}
