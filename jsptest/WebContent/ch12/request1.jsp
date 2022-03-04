<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MemberDTO dto = new MemberDTO("ID", "PW", "Name", "010-0000-0000", "email@a.com", "주소");
request.setAttribute("dto", dto);
// jsp의 내장객체는 바로 사용. RequestDispatcher는 내장객체가 아니다.
RequestDispatcher rd = request.getRequestDispatcher("request2.jsp");
out.println("이동 직전: 무시");
rd.forward(request, response); // out.clear()가 자동실행되는 것과 마찬가지. 이렇게 되면 임시저장공간인 버퍼를 싹 날리고 forward하러 간다. 
out.println("이동 후: 무시. forward후 안돌아온다.");

%>
</body>
</html>