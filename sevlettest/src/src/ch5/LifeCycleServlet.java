package src.ch5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿의 생명주기 메서드

@WebServlet("/life")
public class LifeCycleServlet extends HttpServlet {

// get 방식 요청
// 순서) 
// 1. 서블릿이 실행되고 init메서드 1번만 호출 
// 2. doGet 호출되면 브라우저에 출력. 요청할 때마다 호출 
// 3. destroy 메서드 : 서블릿 코드 수정-재컴파일(자동)-서버 서블릿 reload(이전 서블릿 삭제)될 때 destroy메서드 호출된다. 즉, 서블릿이 메모리에서 없어져야 할 때 호출.
	
	int cnt = 0;	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 브라우저 출력
		response.getWriter().append("<h1>"+ ++cnt + "</h1>");
		System.out.println("===doGet호출중(수정2)===");
	}

	@Override
	public void destroy() {
		// 서버 컴퓨터의 콘솔창에 출력. 브라우저에는 출력 x.
		System.out.println("===destroy호출중===");
	}

	@Override
	public void init() throws ServletException {
		// 서버 컴퓨터의 콘솔창에 출력. 브라우저에는 출력 x.
		System.out.println("===init호출중===");
	}

}