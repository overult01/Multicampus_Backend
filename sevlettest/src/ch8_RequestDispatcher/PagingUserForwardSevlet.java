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

// http:.../paginguser?page=1
@WebServlet("/paginguserforward")
public class PagingUserForwardSevlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageString = request.getParameter("page");
		int page = 1;
		if(pageString != null) {//page 파라미터 입력 상태
			page = Integer.parseInt(pageString);
		}
		int userPerPage = 3;
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.selectMember(page, userPerPage);//id 정렬해서 1페이지 3개만 출력

		// 출력
/*		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		for( MemberDTO dto : list ) {
			//out.println(dto.getId() + " : " + dto.getName()+"<br>");
			out.println(dto + "<br>");
			
		}
*/		
		// forward 
		RequestDispatcher rd = request.getRequestDispatcher("alluserlist"); // 출력결과 같이 사용
		request.setAttribute("memberlist", list); // forward전에만 setAttribute 하면 된다. 
		rd.include(request, response); // forward는  이동. forward이후엔 되돌아오지 않는다. 되돌아오고 싶다면 include사용
		
		//가입된 멤버 수에 따라 페이지번호 생성-9
		int total = dao.getTotalCount();
		int pagenum = 0;
		if(total % userPerPage == 0) {
			pagenum = total / userPerPage  ;
			
		}
		else {
			pagenum = total / userPerPage  + 1;
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		for(int i = 1; i <= pagenum ;i++ ) {
			out.println("<a href=paginguser?page=" + i +" >" + i + " 페이지 </a> ");
		}
	}
}
