package ch9_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/boardwriting")
public class BoardWritingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청된 브라우저의 세션 객체를 가져온다.(최초인지 아닌지에 따라서 2가지가 나뉨)
		HttpSession session = request.getSession();
		// 1번상황: 최초로 브라우저 열고 현재파일 요청: 세션이 없다 -> 세션 객체 새로 생성 
		// 2번 상황: 브라우저 열어두고 다른 서블릿을 실행한 뒤 현재파일 요청 -> 세션이 이미 있는 상태. 이미 생성된 세션객체 가져온다.
		
		// 요청 파라미터 id를 세션에 저장(세션은 서버측에만 저장)
//		if(session.getAttribute("session_id") != null) {
		String session_id = (String)session.getAttribute("session_id");
		
		// 브라우저 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(session.getAttribute("session_id") != null) {
			out.println("<h1>" + session_id + "회원님, 글쓰기 가능합니다.</h1>");
			
			out.println("<table><th>글쓰기 폼</th>"
					+ "<tr><td>제목</td><td><input type = text placeholder = 제목작성></td></tr>"
					+ "<tr><td>내용</td><td><textarea>글작성</textarea></td></tr>"
					+ "<tr><td>작성자</td><td>" + session_id +"</td></tr>"
					
					+ "</table>");
		}
		
	}

}
