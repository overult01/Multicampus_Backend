package ch8_RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch7_crud.MemberDTO;

//requestDispatcher : 포워드. 역할분담이다. 
// 객체 넘기는 예제 (서블릿 간 forward로)
@WebServlet("/forward3")
public class ForwardServlet_set2_1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청(/뒤에 ?와 &로 연결해서 값 입력받아도 되지만, html로 입력값을 받아야 더 편리)
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		// MemberDTO 객체
		MemberDTO dto = new MemberDTO(id, pw, name, phone, email, address);

		
		// 처리(구현생략)
		
		// 응답. 자체 응답하지 말것. 에러는 안나지만 출력되지는 않고 무시되어 forward2로 응답이 포워드된다(넘어간다. 역할분담)
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// out.println("<h1> forward1 출력 =" + id + "</h1>");
		
		// 포워드: 다른 파일로 이동 응답 . 서블릿 이동, html 이동, jsp 이동(같은 컨텍스트 내부) 3방법 가능.
		RequestDispatcher rd = request.getRequestDispatcher("forward4"); // /는 루트기준 경로. 404에러가 나면 경로가 잘못되었는지 확인해볼 것. 		
		// 사용자가 회원가입 : member_table insert 구현 후. but html은 객체를 받아도 이해를 못한다. 따라서 의미 x.
//		RequestDispatcher rd = request.getRequestDispatcher("loginservlet.html");  		

		request.setAttribute("dto", dto); // dto 객체 자체를 전달. 
		rd.forward(request, response); // doGet메서드들의 매개변수들
		
	}

}
