package ch8_RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include2")
public class IncludeServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = request.getParameter("id");
		// include: include1(보낸쪽)에 합쳐져서 보내진다. forward는 전달받은 쪽으로 제어가 넘어가는 것과 차이.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + request.getRequestURI() + "</h1>");
		out.println("<h1>" + request.getAttribute("forward_id") + "</h1>"); // forward1에서 request.setAttribute로 넘겨준 변수 받기.
		
	}

}
