package ch7_crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// 시작화면
//form태그 이용해서 서블릿에 요청하기

// http://localhost:9090/servlettest/login
@WebServlet("/logindb")
public class DB_LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청자로부터 사용자가 입력한 id, pw추출
		String id = request.getParameter("id"); // getParameter: input태그의 name속성의 값. 서버쪽에서는 name속성을 읽어온다.
		String pw = request.getParameter("pw"); 
		
		MemberDAO dao = new MemberDAO();
		int result = dao.selectMember(id, pw);
		// result가 0: 정상로그인, 1: 암호 틀림, 2: id 틀림
		String printing = "";
		if(result == 0) {
			printing = "<h3 style = color:green>" + id + " 회원님 정상 로그인 되셨습니다.</h3>";
			printing += "<h3><a href = alluser> 모든 회원리스트 조회 </a></h3>";			
			// paginguser는 ?파라미터 받는다 (기본값은 ?page=1)
			printing += "<h3><a href = paginguser> 페이지 처리된 회원리스트 조회(기본 page1) </a></h3>";			
			printing += "<h3><a href = updateform?id=" + id + "&pw=" + pw +"> 본인 정보 조회&수정 </a></h3>";			
			printing += "<h3><a href = delete?id=" + id + "> 회원탈퇴 </a></h3>";			
		}
		else if(result == 1) {
			printing = "<h3 style = color:blue>" + id + " 회원님 암호를 확인하세요.</h3>";
			printing += "<a href=db_loginServlet.html > 다시 로그인하러 가기 </a>";			
		}
		else {
			printing = "<h3 style = color:red>" + id + "는 존재하지 않습니다.</h3>";
			printing += "<a href=jdbc_insertServlet.html > 회원가입하러 가기 </a>";			
		}
		
		// 처리
		// 결과 응답 내용
		response.setContentType("text/html;charset=utf-8"); // setContentType: 지금 내가 보낼 내용이 html 문서임을 알려주는 것. html의 meta태그 내 utf-8지정하는 것처럼.
		PrintWriter out = response.getWriter(); // 서버 출력 = 클라이언트로 전송. 응답결과는 PrintWriter타입이다. 
		out.println(printing);
		
	}

}
