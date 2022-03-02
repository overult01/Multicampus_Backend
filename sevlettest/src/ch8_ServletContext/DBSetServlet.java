package ch8_ServletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ServletContext 객체로 현재 컨택스트내 모든 파일과 객체를 공유.
@WebServlet("/dbset")
public class DBSetServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 서블릿 컨텍스트 정보 객체.
		ServletContext context = getServletContext();

		DBInform db = new DBInform();
		db.setDriverName("com.mysql.cj.jdbc.Driver");
		db.setJdbcUrl("jdbc:mysql://localhost:3306/employeesdb");
		db.setAccount("emp");
		db.setPassword("12345678");
		
		// 현재 같은 컨텍스트 안에 있는 서블릿간의 객체 공유. 
		context.setAttribute("share_db", db);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>db정보 공유했습니다</h1>");
	}

}
