package ch9_cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookcookieset")
public class BookCookieSetServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// url뒤에 ?title 로 사용자가 입력한 타이틀값 받기 

		String title = request.getParameter("title");
		
//		ArrayList<String> title_list = new ArrayList<String>();
//		title_list.add(title);
//		String list_str = String.join(",", title_list);
		
		
//		Cookie title_cookie = new Cookie("title", title);
		
		
		response.addCookie(new Cookie("title", title));
		
		// 브라우저 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>쿠키를 저장하였습니다.</h1>");
	}

}
