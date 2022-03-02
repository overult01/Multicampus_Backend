package ch8_RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch7_crud.MemberDTO;

//DB, forward혼합 예제 
// 받는 쪽, 출력만 담당
// 얘만 출력하면 500에러:NullPointerException
@WebServlet("/alluserlist")
public class AllUserListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 처리된 결과를 가져와서 출력만. (모든 회원정보 가져오기 처리: alluserforward)

		// request.getAttribute로 받을 때, 원래 타입으로 받을 필요(형변환)
		ArrayList<MemberDTO> memberlist = (ArrayList<MemberDTO>)request.getAttribute("memberlist");

		// 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		for(MemberDTO dto : memberlist) {
			out.println(dto + "<br>");
		}
		out.println("<h1> 출력담당: " + request.getRequestURI() +"</h1>");
	}

}
