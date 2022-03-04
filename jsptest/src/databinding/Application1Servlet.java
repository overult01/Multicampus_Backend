package databinding;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;

@WebServlet("/application1")
public class Application1Servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO dto = new MemberDTO("ID", "PW", "Name", "010-0000-0000", "email@a.com", "주소");
		ServletContext application = getServletContext();
		// 1. 서버 시작시 최초 호출되면 1개 생성된다. 서버종료될 때까지 공유된다.		
		
		application.setAttribute("app_dto", dto);
		// forward가 아니라서 rd 필요 x.
		// RequestDispatcher rd = request.getRequestDispatcher("request2.jsp");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter o = response.getWriter();
		
		o.println("컨텍스트 저장 완료");
	}

}
