package ch7_crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert_jdbc")
public class InsertServlet extends HttpServlet {
	
	// html -> form정보를 서블릿이 받아옴 -> 서블릿이 dto에입력데이터 전달 -> dao에 dto전달 -> dao가 db에 입력 
	
	
	// get 방식, post 방식 동시에 처리하기
	// doGet, doPost메서드 모두 만들고 html내 form태그내 method속성에서 get, post 둘 중 하나 선택하여 사용하면 된다. 
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// doPost메서드 사용시 한글 깨지지 않도록 인코딩
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
//		String[] hobby = request.getParameterValues("hobby"); // 배열타입으로 리턴 
//		String[] specialty = request.getParameterValues("specialty"); // 배열타입으로 리턴 

		// 사용자가 입력했던 정보를 가지고 memberDTO 객체를 생성.
		MemberDTO dto = new MemberDTO(id, pw, name, phone, email, address);
		MemberDAO dao = new MemberDAO();
		dao.insertMember(dto); 
		//MYSQL - NOT NULL 체크안함
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3 >"  +id + "</h3>");
		out.println("<h3 >"  +pw + "</h3>");
		out.println("<h3 >"  +name + "</h3>");
		out.println("<h3 >"  +phone + "</h3>");
		out.println("<h3 >"  +email + "</h3>");
		out.println("<h3 >"  +address + "</h3>");
		out.println("<h3> 정상적으로 회원가입하셨습니다.<h3>");
	
		//html로 forwarding
		/*RequestDispatcher rd = request.getRequestDispatcher("loginservlet.html");
		rd.forward(request, response);*/
	}
}
