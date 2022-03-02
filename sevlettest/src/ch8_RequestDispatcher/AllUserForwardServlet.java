package ch8_RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch7_crud.MemberDAO;
import ch7_crud.MemberDTO;

// DB, forward혼합 예제 
// 전달하는 쪽: DB연동해서 리스트 가져오는 역할. 
@WebServlet("/alluserforward")
public class AllUserForwardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 전달하는 데이터 없다
		//처리
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.selectMember();//모든사용자조회
		//응답
		// 원래출력은 아래. forward해보기.
/*		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		 for( MemberDTO dto : list ) {
			//out.println(dto.getId() + " : " + dto.getName()+"<br>");
			out.println(dto + "<br>");
			
		}
*/		
		
		// forward: alluserlist 서블릿에 리스트 전달
		request.setAttribute("memberlist", list);
		RequestDispatcher rd = request.getRequestDispatcher("alluserlist"); // 경로 동일해서 서블릿 이름만 기입
		rd.forward(request, response);
	}

}