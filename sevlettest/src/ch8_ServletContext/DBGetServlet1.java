package ch8_ServletContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// dbset으로부터 정보 공유받는 서블릿. dbset이 먼저 실행되어야.
// 브라우저 종료한뒤 다시 들어가도 서버는 살아있으므로 정보전달받음.
@WebServlet("/dbget1")
public class DBGetServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 서블릿 컨텍스트 정보 객체.
		ServletContext context = getServletContext();
		// 객체 가져오기 
		DBInform db = (DBInform)context.getAttribute("share_db");
		
		try {
			Class.forName(db.getDriverName());
			Connection conn = DriverManager.getConnection(db.getJdbcUrl(), db.getAccount(), db.getPassword());
			PreparedStatement pt = conn.prepareStatement("select count(*) from member_table");
			ResultSet rs = pt.executeQuery();
			rs.next();
//			System.out.println(rs.getInt("count(*)"));
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<h1>db내에 " + rs.getInt("count(*)") + "개의 행 존재</h1>");

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
