package databinding;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;

@WebServlet("/session1")
public class Session1Servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO dto = new MemberDTO("ID", "PW", "Name", "010-0000-0000", "email@a.com", "주소");
		
		HttpSession session = request.getSession();
		// 1. 브라우저 열고 최초 호출되면, 세션 1개 생성. 브라우저 당 세션은 1개만 생긴다.
		// 2. 두 번째 호출에서는 세션 객체리턴
		
		
		session.setAttribute("session_dto", dto);
		// forward가 아니라서 rd 필요 x.
		// RequestDispatcher rd = request.getRequestDispatcher("request2.jsp");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter o = response.getWriter();
		
		o.println("세션");
	}

}
