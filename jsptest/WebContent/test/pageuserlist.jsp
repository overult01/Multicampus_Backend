<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PagingUserServlet 출력 내용처럼 출력하기</title>

</head>
<body>

<%
	int pageInt = 1;
	int userPerPage = 3;

// jsp는 내장객체 request, response, open를 가진다. 바로 사용가능. 
	String strpage = request.getParameter("page");
	if (strpage != null){
		pageInt = Integer.parseInt(strpage); 
	}
	
	MemberDAO dao = new MemberDAO();
	
	ArrayList<MemberDTO> list = dao.selectMember(pageInt, userPerPage);
	
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
		out.println("<a href=/jsptest/test/pageuserlist.jsp?page=" + i +" >" + i + " 페이지 </a> ");
	}

%>

</body>
</html>