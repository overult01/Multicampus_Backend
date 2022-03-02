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
// 보내는 쪽, 받는 쪽의 데이터 공유방법: 보내는 쪽은 setAttribute메서드, 받는 쪽은 getAttribute메서드
@WebServlet("/forward1")
public class ForwardServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		// id값 읽어오는 건 forward1에서, 출력은 forward2에서 처리. 
		String id = request.getParameter("id");

		// 처리(구현생략)
		
		// 응답. 자체 응답하지 말것. 에러는 안나지만 출력되지는 않고 무시되어 forward2로 응답이 포워드된다(넘어간다. 역할분담)
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> forward1 출력 =" + id + "</h1>");
		
		// 포워드: 다른 파일로 이동 응답  
		RequestDispatcher rd = request.getRequestDispatcher("/test/forward2"); // /는 루트기준 경로. 404에러가 나면 경로가 잘못되었는지 확인해볼 것. 		
		// 포워드시 request 객체자체를 넘기게 되어있다. 
		// forward2로 포워드 하기 전에 request안에다 변수를 추가한 것. 
		request.setAttribute("forward_id", id); // setAttribute(f1에서 f2로 전달할 때 공유할 변수명, 전달할 변수). 전달받은 쪽은 받을 때 getAttribute메서드를 쓰면 된다. 
		rd.forward(request, response); // doGet메서드들의 매개변수들
		
	}

}
