package ch5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// url 매핑되는 부분
@WebServlet("/second") 
public class SecondServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<h1>===웹브라우저가 해석할 수 있는 부분. 서블릿에서는 body태그의 내부것부터 작성===</h1>");
	}

}