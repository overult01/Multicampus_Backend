package ch8_RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/forward2")
public class ForwardServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = request.getParameter("id");
		// 포워드 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + request.getRequestURI() + "</h1>");
		out.println("<h1>" + request.getAttribute("forward_id") + "</h1>"); // forward1에서 request.setAttribute로 넘겨준 변수 받기.
		
	}

}
