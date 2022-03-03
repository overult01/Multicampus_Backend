package teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookcookie")
public class BookCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/* c_id:xxx(24시간) c_name:xxx c_time:xxxx */
		
		//title파라미터 읽어오자
		String title = request.getParameter("title");
		Cookie book_cookie = null;
		String printing = "";
		//쿠키 읽어오자. 
		Cookie[] c_array = request.getCookies();
		for(Cookie c : c_array) {
			if(c.getName().equals("book")) {//도서정보저장 쿠키 있다.
				c.setValue(c.getValue() + "-" + title);
				book_cookie = c;
				response.addCookie(book_cookie);
				printing = "<h1>지금까지 선택하신 도서는 "
						+ c.getValue() + " 선택하셨습니다";
			}
			else {//도서정보저장 쿠키 없다.
				book_cookie = new Cookie("book", title);
				book_cookie.setMaxAge(30*24*60*60);
				response.addCookie(book_cookie);
				printing = "<h1>지금까지 선택하신 도서는 없습니다</h1>";
			}
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(printing);
	
	}

}
