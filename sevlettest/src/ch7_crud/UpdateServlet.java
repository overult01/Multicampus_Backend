package ch7_crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 6개 정보: pw, name, address만 수정 가능.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(id, pw, name, phone, email, address); // 6개 정보를 모두 읽어서 
		dao.updateMember(dto); // dto매개변수로 정보 업데이트 
		
		// 수정된 부분 무엇인지 알려주는 출력 응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(dto.getPassword() + "<br>");
		out.println(dto.getName() + "<br>");
		out.println(dto.getAddress() + "<br>");
		out.println("위 사항들을 수정하였습니다.");

	}

}
