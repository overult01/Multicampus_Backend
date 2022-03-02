package ch9_cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		// db에 가서 입력된 id에 해당하는 name값 조회했다고 가정 
		Cookie name_cookie = new Cookie("c_name", "김삼성"); // c_name이 브라우저에 저장되는 이름. 브라우저가 종료되면 없어진다.
		// 만약 쿠키값을 저장에 한글,공백,특수문자가 깨지면: 인코딩을 utf-8.  
//		Cookie name_cookie = new Cookie("c_name", java.net.URLEncoder.encode("김삼성", "utf-8")); 
		
		// 옵션: 24시간 쿠키가 유효하도록 설정. 브라우저를 닫아도 설정 시간동안에는 쿠키가 살아있다.
		id_cookie.setMaxAge(60*60*24); 
		
		// 사용자의 로그인 시각을 쿠키로 저장 
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.format(now);
		// IllegalArgumentException
		Cookie time_cookie = new Cookie("c_time", 
				java.net.URLEncoder.encode(sdf.format(now), "utf-8"));
		
		// 쿠키 전달
		response.addCookie(id_cookie);
		response.addCookie(name_cookie);
		response.addCookie(time_cookie);
		
		// 브라우저 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>쿠키를 저장하였습니다.</h1>");
	}

}
