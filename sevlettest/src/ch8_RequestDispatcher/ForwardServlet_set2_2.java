package ch8_RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch7_crud.MemberDTO;
// 객체 forward 예제 
@WebServlet("/forward4")
public class ForwardServlet_set2_2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 원래 타입으로 형변환 필요 
		MemberDTO dto = (MemberDTO)request.getAttribute("dto");

		// 포워드 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + request.getRequestURI() + "</h1>");
		// 전달받은 객체 dto 출력. MemberDTO에서 toString 메서드 오버라이딩했으므로 그 결과가 나올 것. 
		out.println("<h1>" + dto + "</h1>"); 
		
	}

}
