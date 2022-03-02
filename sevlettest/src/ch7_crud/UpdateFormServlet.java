package ch7_crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// id, pw전달받아야
@WebServlet("/updateform")
public class UpdateFormServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id, pw 입력받아서 db에서 입력된 id, pw맞다면 해당 회원정보 가져와서 수정폼 입력할 수 있게.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.updateFormMember(id, pw);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if(dto != null) {
			// dto 안에 들어있는 모든 정보들을 html form양식으로 보여주자 
			String printing = "<form action = update>";
			printing += "아이디(수정불가)<input type = text name = id value = '" + dto.getId() + "'readonly><br>" 
			+ "암호변경<input type = password name = pw value = '" + dto.getPassword() + "'><br>" 
			+ "이름변경<input type = text name = name value = '" + dto.getName() + "'><br>" 
			+ "폰번호(수정불가)<input type = text name = phone value =	'" + dto.getPhone() + "' readonly><br>"
			+ "이메일(수정불가)<input type = text name = email value =	'" + dto.getEmail() + "' readonly><br>"
			+ "주소<input type = text name = address value = '" + dto.getAddress() + "' ><br>"
			+ "<input type = submit value =수정 <br></form>";
			out.println(printing);
		}
		else {
			out.println("<h1>해당 회원의 정보는 찾을 수 없습니다.</h1>");
			
		}
	}
	

}
