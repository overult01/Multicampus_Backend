<!-- 페이지 디렉티브 태그 -->
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 디렉티브 태그, 스크립트릿 태그</title>
</head>
<body>

<!-- 주석1: html주석(자바문법 아닌 경우) -->
<%-- 주석2: <% jsp주석(내부 자바문법 사용) %> --%>
<%
/* 주석3: jsp내부에는 자바 주석을 쓴다. */
%>


<!-- 사용자의 요청을 get 방식, post방식으로 분리하지 않고 다 받을 수 있다. 
(서블릿은 방식따라 doGet, doPost로 메서드 분리)
 -->
 
<h1> <!-- 출력내용 담기용 h1 태그  -->
<% 
// 스크립트릿 태그 : 자바문장 들어가는 태그.
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	MemberDAO dao = new MemberDAO();
	int result = dao.selectMember(id, pw);
	// 0, 1, 2
	if (result == 0) {
		out.println("정상 로그인 사용자입니다.");
	} else if (result == 1) {
		out.println("암호를 확인하세요.");
	} else {
		out.println("회원가입하세요.");
	}
	
	
%> 
</h1>

</body>
</html>