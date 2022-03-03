package ch9_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 브라우저 내부에서 데이터 공유 하는 방법
// 쿠키, 세션 중 세션
@WebServlet(name = "a", urlPatterns = {"/loginsession"})
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id, pw 입력받아 로그인정보 받아온다.
		// 세션저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// db에서 정상로그인인지 확인하는 구현은 생략
		
		// 요청된 브라우저의 세션 객체를 가져온다.(최초인지 아닌지에 따라서 2가지가 나뉨)
		HttpSession session = request.getSession();
		// 1번상황: 최초로 브라우저 열고 현재파일 요청: 세션이 없다 -> 세션 객체 새로 생성 
		// 2번 상황: 브라우저 열어두고 다른 서블릿을 실행한 뒤 현재파일 요청 -> 세션이 이미 있는 상태. 이미 생성된 세션객체 가져온다.
		
		// 요청 파라미터 id를 세션에 저장(세션은 서버측에만 저장) 
		session.setAttribute("session_id", id);
		
		// 브라우저 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(id != null & pw != null) {
			out.println(id+"회원님 환영합니다.");
			out.println("<h1>사용 가능 메뉴는 다음과 같습니다.</h1>");
			out.println("<ul><li><a href = mypage > 내정보 확인하러 가기</a></li>");
			out.println("<li><a href = boardwriting > 글쓰러 가기</a></li>");
			out.println("<li><a href = logout > 로그아웃하러 가기</a></li></ul>"); // a태그로 이동시에는 세션을 통해서만 데이터 공유 가능. 반면 requestDispatcher의 forward, include는 이동과 데이터 전달 모두 가능.
		}
		else {
			out.println("로그인정보를 입력하세요.");
		}
	}

}
