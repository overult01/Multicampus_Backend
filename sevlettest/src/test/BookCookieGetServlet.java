package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookcookieget")
public class BookCookieGetServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 출력 준비
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 쿠키 가져오기
		request.getCookies(); // 쿠키는 여러개일 수 있어서, cookie 배열 리턴된다.
		Cookie[] c_array = request.getCookies();
		out.println("지금까지 선택하신 도서는");
		for(Cookie c : c_array) { 
			out.println(java.net.URLDecoder.decode(c.getValue(), "utf-8") + ", ");
			};
		out.println("입니다.");
			// 만약 쿠키값을 저장에 한글,공백,특수문자가 깨지면: 디코딩을 utf-8.  
//			 out.println("쿠키값 = " + java.net.URLDecoder.decode(c.getValue(), "utf-8"));
		}


}
