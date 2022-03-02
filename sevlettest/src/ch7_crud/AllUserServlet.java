package ch7_crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/alluser")
public class AllUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 전달하는 데이터 없다
		//처리
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.selectMember();//모든사용자조회
		//dao.selectMember(id, pw);//로그인사용자판별
		//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		for( MemberDTO dto : list ) {
			//out.println(dto.getId() + " : " + dto.getName()+"<br>");
			out.println(dto + "<br>");
			
		}
	}

}