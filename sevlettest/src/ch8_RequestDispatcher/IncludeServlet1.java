package ch8_RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//requestDispatcher : 포워드. 역할분담이다. 
// include : 보내는 쪽, 받는 쪽의 데이터 모두 출력하고 싶을 때
// 보내는 쪽, 받는 쪽의 데이터 공유방법: 보내는 쪽은 setAttribute메서드, 받는 쪽은 getAttribute메서드
@WebServlet("/include1")
public class IncludeServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		// id값 읽어오는 건 forward1에서, 출력은 forward2에서 처리. 
		String id = request.getParameter("id");

		// 처리(구현생략)
		
		// 응답. forward메서드를 include로 바꿨을 떄. 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> include1 출력 =" + id + "</h1>");
		
		// 포워드: 다른 파일로 이동 응답  
		RequestDispatcher rd = request.getRequestDispatcher("include2"); // /는 루트기준 경로. 404에러가 나면 경로가 잘못되었는지 확인해볼 것. 		

		request.setAttribute("forward_id", id); // setAttribute(f1에서 f2로 전달할 때 공유할 변수명, 전달할 변수). 전달받은 쪽은 받을 때 getAttribute메서드를 쓰면 된다. 
		rd.include(request, response); // 이전에 출력할 변수 저장.
		// include는 포함한 뒤, 갔다가 돌아온다. 그런 면에서 아래 문장 출력. 
		out.println("<h1> include한 후(포함한 후) =" + id + "</h1>");
		
	}

}
