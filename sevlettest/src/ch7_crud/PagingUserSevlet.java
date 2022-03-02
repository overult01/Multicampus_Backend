package ch7_crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 수정필요
// http:.../paginguser?page=1
@WebServlet("/paginguser")
public class PagingUserSevlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageString = request.getParameter("page");
		int page = 1;
		if(pageString != null) {//page 파라미터 입력 상태
			page = Integer.parseInt(pageString);
		}
		int userPerPage = 3;
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.selectMember(page, userPerPage);//id 정렬해서 1페이지 3개만 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		for( MemberDTO dto : list ) {
			//out.println(dto.getId() + " : " + dto.getName()+"<br>");
			out.println(dto + "<br>");
			
		}
		
		//가입된 멤버 수에 따라 페이지번호 생성-9
		int total = dao.getTotalCount();
		int pagenum = 0;
		if(total % userPerPage == 0) {
			pagenum = total / userPerPage  ;
			
		}
		else {
			pagenum = total / userPerPage  + 1;
		}
		for(int i = 1; i <= pagenum ;i++ ) {
			out.println("<a href=paginguser?page=" + i +" >" + i + " 페이지 </a> ");
		}
	}
}
