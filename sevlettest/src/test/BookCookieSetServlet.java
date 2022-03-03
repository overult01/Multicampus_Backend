package test;

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
		// url뒤에 ?title 로 사용자가 입력한 타이틀값 받기 : title 파라미터 읽어오기
		String title = request.getParameter("title");
		Cookie book_cookie = null;
		String printing = "";
		
		// 쿠키 읽어오기
		Cookie[] c_array = request.getCookies();
		for (Cookie c : c_array) {
			if(c.getName().equals("book")) { // 도서정보 저장된 쿠키 있으면
				// setValue: 기존 쿠키에 저장된 정보 수정. 쿠키의 value값 갱신
				c.setValue(c.getValue() + "," + title);
				book_cookie = c;
				response.addCookie(book_cookie);
				printing = "<h1>지금까지 선택하신 도서는 " 
						+ c.getValue() + "선택하셨습니다";
			} else { // 도서정보 저장 쿠키 없으면
				book_cookie = new Cookie("book", title);
				// book_cookie.setMaxAge(초*분*시);
				response.addCookie(book_cookie);
				printing = "<h1>지금까지 선택하신 도서는 없습니다.</h1>" ;
			}
		}
//		ArrayList<String> title_list = new ArrayList<String>();
//		title_list.add(title);
//		String list_str = String.join(",", title_list);
		
		
//		Cookie title_cookie = new Cookie("title", title);
		
				
		// 브라우저 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(printing);
	}

}
