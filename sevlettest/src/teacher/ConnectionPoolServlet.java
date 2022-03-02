package teacher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/conpool")
public class ConnectionPoolServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 try {
	//test1	
/*	 Class.forName("com.mysql.cj.jdbc.Driver");
		for(int i = 1; i <=10000; i++) {
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(i + " 번째 " + conn  + " 연결성공");
	 
		//test2   주석 해제(주석시에는 db 다운, 서버 다운 확인)
		//주석 해제시 10000 번 모두 반복, 속도 느림.
		//conn.close(); 
		}
 */
	 
// test3 아래 코드로 반복문 출력문장 속도차이 비교. 빠르다
// 위 코드로 인해 con 을 소진했으므로 tomcat 재시작하고 실행
		
	//1. context = dynamic web project
	 //servlettest 관련설정 가능 
	 Context initContext = new InitialContext();
	//2. context.xml : 설정 읽어와라.
	 Context envContext = 
	(Context)initContext.lookup("java:/comp/env"); 
	//3. name=jdbc/myoracle 설정 객체 읽어와라
	 //ds = connectionpool 객체 
	 DataSource ds = 
	(DataSource)envContext.lookup("jdbc/mydb"); 
	 
	for(int i = 1; i <= 10000; i++) {
	//4. connectionpool 객체 con 빌려와라
	 Connection con = ds.getConnection();	
    //sql 작업
	 System.out.println(i + " 번째 연결 " +con+"완료");
	 con.close();//connectionpool 객체 반납 
	 
	}//for end
	  
	 
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
