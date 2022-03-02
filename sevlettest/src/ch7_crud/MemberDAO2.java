package jdbc_servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO {
	// member 테이블 기능 단위 메서드
	// CRUD : create / read / update / delete
	
	// dto로부터 사용자 입력값을 받아온 상태.
	public void insertMember(MemberDTO dto) {
		// jdbc
		try {
		// 1. jdbc 드라이버 호출
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. db 연결
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "12345678");
		System.out.println("db연결");
		
		// 3. sql 처리 - insert
		PreparedStatement pt1 = conn.prepareStatement("insert into member_table values(?,?,?,?,?,?)");
		pt1.setString(1, dto.getId());
		pt1.setString(2, dto.getPassword());
		pt1.setString(3, dto.getName());
		pt1.setString(4, dto.getPhone());
		pt1.setString(5, dto.getEmail());
		pt1.setString(6, dto.getAddress());
		int rows = pt1.executeUpdate(); // sql실행 변화행 개수
		System.out.println(rows);
		

		
		pt1.close();
		conn.close();
		System.out.println("db연결 해제");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
