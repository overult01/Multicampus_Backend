package databinding;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;

@WebServlet("/request1")
public class Request1Servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO dto = new MemberDTO("ID", "PW", "Name", "010-0000-0000", "email@a.com", "주소");
		request.setAttribute("dto", dto);
		// jsp의 내장객체는 바로 사용. RequestDispatcher는 내장객체가 아니다.
		RequestDispatcher rd = request.getRequestDispatcher("request2.jsp");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter o = response.getWriter();
		
		// jsp와 달리 서블릿은 out이 내장객체가 아니라서 변수명 변경가능.
		o.println("이동 직전: 무시");
		rd.forward(request, response); 
		o.println("이동 후: 무시. forward후 안돌아온다.");
	}

}
