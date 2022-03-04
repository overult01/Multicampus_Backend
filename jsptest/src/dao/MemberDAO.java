package dao;
//crud메소드 -> create + read(특정id + 모든id) + update + delete 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import dto.MemberDTO;


public class MemberDAO {
	
	public int deleteMember(String id) {

		Connection conn = null;
		int rows = 0;
		
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "12345678");
		System.out.println(" mysql db연결성공");
		
		String sql = "delete from member_table where id=?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, id); // 1번째 ?에는 id 
		rows = pt.executeUpdate(); // 삭제된 행의 개수 

		System.out.println(rows);
				
		conn.close();
		System.out.println(" mysql db연결해제");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return rows;
		
		// 탈퇴 관리하려면
		// insert into 새로운테이블 ..
	}
	
	// update
	// 정상 사용자가 로그인했다면 이 사람의 모든 정보를 출력
	public MemberDTO updateFormMember(String id, String pw) {
		
		MemberDTO dto = null;
		
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "12345678");
		System.out.println(" mysql db연결성공");
		
		String sql = "select * from member_table where id = ? and password =?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, id); // 1번째 ?에는 id 
		pt.setString(2, pw);
		
		ResultSet rs = pt.executeQuery();
		// 여기서 rs.next()는 0 또는 1 리턴.
		if(rs.next()) { // 1
			dto = new MemberDTO(rs.getString("id"), rs.getString("password"),
					rs.getString("name"), rs.getString("phone"),
					rs.getString("email"), rs.getString("address")
					);
		}
				
		conn.close();
		System.out.println(" mysql db연결해제");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dto; // 조회한 회원의 정보를 담은 객체 
	}
	
	public void updateMember(MemberDTO dto) {
				
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "12345678");
		System.out.println(" mysql db연결성공");
		
		String sql = "update member_table set password=?, name=?, address=? where id=?"; // update 테이블명 set 변경컬럼 = 변경값 , , .. where 변경조건 
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, dto.getPassword()); // 1번째 ?에는 id 
		pt.setString(2, dto.getName());
		pt.setString(3, dto.getAddress());
		pt.setString(4, dto.getId());
		
		int cnt = pt.executeUpdate();
		
		System.out.println(cnt);
	
				
		conn.close();
		System.out.println(" mysql db연결해제");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 현재 회원이 몇 명인지 세는 메서드
 	public int getTotalCount() {
		int total = 0;
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "12345678");
		System.out.println(" mysql db연결성공");
		
		String sql = "select count(*) from member_table";
		PreparedStatement pt = conn.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();
		rs.next() ;//1개행 리턴( 0, 10값)
		total = rs.getInt("count(*)");	
		
		
		conn.close();
		System.out.println(" mysql db연결해제");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return total;		
	}
	
	// 전체 사용자 select
	public ArrayList<MemberDTO> selectMember() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "12345678");
		System.out.println(" mysql db연결성공");
		
		String sql = "select * from member_table";
		PreparedStatement pt = conn.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();//rs 행갯수 0 또는 n
		while(rs.next() == true) {
			MemberDTO dto = new MemberDTO(
					rs.getString("id"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("phone"),
					rs.getString("email"),
					rs.getString("address")
					);
			list.add(dto);
		}//while end

		
		conn.close();//rs 조회 더이상 불가
		System.out.println("mysql db연결해제성공");	
	}catch(Exception e) {
		e.printStackTrace();
	}
		return list;
	}
	
	// 사용자 1명만 select
	public int selectMember(String id, String pw) {
		int result = 0;
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "12345678");
		System.out.println(" mysql db연결성공");
		
		String sql = "select * from member_table where id=?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1 , id);
		ResultSet rs = pt.executeQuery();//rs 행갯수 0 또는 1
		if(rs.next() == true) {
			String pwdb = rs.getString("password");
			if(pwdb.equals(pw)) {//암호 동일하면
				result = 0;
			}
			else { //암호 동일하지 않으면
				result = 1;
			}
		}
		else {//행갯수 0 = id 존재하지 않는다
			result = 2;
			
		}
		/*id member_table에 존재하는지 확인
존재한다면
해당id의 db암호와 pw암호
같은지 비교
같다 return 0
같지 않다 return 1
id 존재하지 않는다면 return 2
*/
		
		conn.close();
		System.out.println("mysql db연결해제성공");	
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 오버로딩
	// 페이징 처리 select. 몇페이지, 한페이지에 몇 명 user를 보여줄 것인지 
	public ArrayList<MemberDTO> selectMember(int page, int userPerPage) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "12345678");
		System.out.println(" mysql db연결성공");
		
		String sql = "select * from member_table limit ?, ?";
		// 1 페이지 입력(페이지번호-1) * 한 페이당 보여줄 회원수
		PreparedStatement pt = conn.prepareStatement(sql);
		
		pt.setInt(1, (page-1) * userPerPage);
		pt.setInt(2, userPerPage);
		
		ResultSet rs = pt.executeQuery();//rs 행갯수 0 또는 n

		while(rs.next() == true) {
			MemberDTO dto = new MemberDTO(
					rs.getString("id"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("phone"),
					rs.getString("email"),
					rs.getString("address")
					);
			list.add(dto);
		}//while end

		
		conn.close();//rs 조회 더이상 불가
		System.out.println("mysql db연결해제성공");	
	}catch(Exception e) {
		e.printStackTrace();
	}
		return list;
	}
	
	
	
	public void insertMember(MemberDTO dto) {
		
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "12345678");
		System.out.println(" mysql db연결성공");
			 

		String sql = "insert into member_table values(?,?,?,?,?,?)";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setNString(1 , dto.getId());
		pt.setNString(2 , dto.getPassword());
		pt.setNString(3 , dto.getName());
		pt.setNString(4 , dto.getPhone());
		pt.setNString(5 , dto.getEmail());
		pt.setNString(6 , dto.getAddress());

		pt.executeLargeUpdate();
		conn.close();
		System.out.println("mysql db연결해제성공");	
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		// 우리의 문법이 잘못되어서 닫히지 않았을 경우를 대비하여 close 
//		finally {
//			conn.close();
//		}
	}

}//CLASS END
