package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
// 수정필요
@WebServlet("/connection")
public class ConnectionPoolServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			for(int i = 1; i <=1000; i++) {
//				Connection conn = DriverManager.getConnection
//				("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "12345678");
//				System.out.println(i + "번째 mysql db연결성공");
//				conn.close(); 
			// 끊지 않으면 중간에 멈추며 에러발생.
//		}	
//				웹서버는 동시에 여러 클라이언트의 접속을 유지해야 한다.(오픈된 환경) 
//				웹클라이언트의 db연결 요구를 연결생성 가능해야 한다.
//				db의 최대 허용치는 제한되어 있다.
//				conn.close(); 는 즉각적으로 db연결을 해제하는 것이 아니고, conn이 소멸할 수 있는 가능성을 준다.
//				db연결 작업은 sql 전송작업보다 작업시간이 오래 소요되는 작업이다.
//				--> 따라서 미리 DB연결을 해두자.(미리 일정개수 conn 생성 -> 소멸하지 않고 conn 재사용)
//				--> 웹서버에서 DB연결할 때 특히 필요하다. (web server db연결)
//				--> 이를 connection pooling이라 한다. 톰캣은 자체적으로 방법을 제공해준다(javax.sql.DataSource api 사용)				
			
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
