package ch9_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String printing = "";
		
		// 세션을 생성 or 세션을 가져오거나
		HttpSession session = request.getSession();
		if(session.getAttribute("session_id") != null) { // 로그인되어있는 상황에서 로그아웃 
			printing = session.getAttribute("session_id") + "회원님";

			// 로그아웃은 세션에 대한 정보를 삭제하면 된다. removeAttribute
			session.removeAttribute("session_id");
			
			// 세션 무효화: 모든 세션의 정보를 한 번에 삭제(removeAttribute로 모든 세션을 각각 지운 것과 같다) 
			// session.invalidate();
			
			// 브라우저에서 30분동안 작업없으면 세션은 자동종료. 기본은 30분이나 시간을 지정할 수 있다. 
			// session.setMaxInactiveInterval(60*60);
			
			printing += "로그아웃하셨습니다.";
		}
		else {
			printing = "<a href = loginsession>로그인 먼저 해주세요</a>";
		}
		
		// 출력 준비
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(printing);
	}

}
