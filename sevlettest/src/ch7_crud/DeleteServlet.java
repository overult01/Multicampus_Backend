package ch7_crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 요청 파라미터 id를 읽어온다.
		String id = request.getParameter("id");
		
		// MemberDAO객체 deleteMember(요청파라미터 id);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if(id == null) {
			id ="손님";
			out.println("<h3>" + id + "회원님 삭제할 id가 없습니다.</h3>");
		}
		else {
			MemberDAO dao = new MemberDAO();
			int i = dao.deleteMember(id); // 삭제행갯수 리턴 가정
			
			
			out.println("<h3>" + id + " 회원님 정보가 삭제되었습니다.</h3>");
			out.println("<h3>" + i + " 개 행이 삭제되었습니다.</h3>");			
		}
		
	
	}

}
