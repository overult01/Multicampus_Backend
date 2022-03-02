package ch9_cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 쿠키의 클라이언트측. : 쿠키 저장하는 역할 
@WebServlet("/cookieset")
public class CookieSetServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 로그인했던 id를 파라미터로 입력받아서 쿠키로 저장.
		String id = request.getParameter("id");
		Cookie id_cookie = new Cookie("c_id", id); // 쿠키로 저장할 이름, 쿠키로 저장할 값 
		// 쿠키 전달
		response.addCookie(id_cookie);
		
		// 브라우저 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>쿠키를 저장하였습니다.</h1>");
	}

}
