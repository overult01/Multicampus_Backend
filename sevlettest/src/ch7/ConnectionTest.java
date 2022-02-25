package ch7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 서블릿의 데이터베이스 연동하기(jdbc)
public class ConnectionTest {

	public static void main(String[] args) {
		// 서블릿 없이도 jdbc가 가능했는데 서블릿을 사용하는 이유는?
		try {
		// 1. jdbc 드라이버 호출
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. db 연결
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "12345678");
		System.out.println("db연결");
		
		// 3. sql 처리 - insert
		PreparedStatement pt1 = conn.prepareStatement("insert into member_table values(?,?,?,?,?,?)");
		pt1.setString(1, "id값2");
		pt1.setString(2, "암호값2");
		pt1.setString(3, "이름2");
		pt1.setString(4, "010-7777-6666");
		pt1.setString(5, "email2@b.com1");
		pt1.setString(6, "인천");
		int rows = pt1.executeUpdate(); // sql실행 변화행 개수
		System.out.println(rows);
		
		
		// sql 처리 - select 
		PreparedStatement pt = conn.prepareStatement("select * from member_table");
		ResultSet rs = pt.executeQuery(); // sql문 실행.
		
		while(rs.next()) { // rs가 있을 때까지 반복. 행이동. db에 데이터가 있는 만큼 반복.
			String id = rs.getString("id"); // 매개변수로 컬럼명 혹은 컬럼인덱스
			String pw = rs.getString("password");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			String address = rs.getString("address");
			System.out.println(id + ":" + pw + ":" + name + ":"
					+ phone + ":" + email + ":" + address);			
		}
		
		pt.close();
		conn.close();
		System.out.println("db연결 해제");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
