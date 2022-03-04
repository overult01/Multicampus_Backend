<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컨텍스트(다이나믹 웹프로젝트 전체): application 객체</title>
</head>
<body>
<%
MemberDTO dto = new MemberDTO("ID", "PW", "Name", "010-0000-0000", "email@a.com", "주소");
application.setAttribute("app_dto", dto);
out.println("<h1>컨텍스트(application)에 정보를 저장했습니다..</h1>");
// 세션으로 공유할 때는 굳이 이동할 필요가 없다 
// jsp의 내장객체는 바로 사용. RequestDispatcher는 내장객체가 아니다.
// RequestDispatcher rd = request.getRequestDispatcher("request2.jsp");
/* out.println("이동 직전: 무시");
// rd.forward(request, response); 
out.println("이동 후: 무시. forward후 안돌아온다."); */

%>
</body>
</html>