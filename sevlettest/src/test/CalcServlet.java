package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String math = request.getParameter("math");
		
		int result = 0;
		
		if (math.equals("+")) {
			result = num1 + num2;
		} else if (math.equals("-")) {
			result = num1 - num2;			
		} else if (math.equals("*")) {
			result = num1 * num2;			
		} else if (math.equals("/")) {
			result = num1 / num2;			
		} else if (math.equals("%")) {
			result = num1 % num2;			
		}
		
		
		
		// 웹 브라우저에 응답
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter();
		
		out.println("<p>" + num1 + math + num2 + "=" + result + "</p>");
		
	}

}
