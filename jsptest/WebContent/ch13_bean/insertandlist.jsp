<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 다시 공부해야 할 부분. jsp 액션 태그..db와 연결</title>
</head>
<body>
<!-- jsp는 post, get방식 상관없지만 post방식에서는 인코딩 utf-8은 반드시 추가해줄 것. -->
<%request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id = "dto" class = "dto.MemberDTO" />

<jsp:setProperty property = "*" name = "dto"/>

<!-- 3. db전송 -->
<jsp:useBean id="dao" class = "dao.MemberDAO" />
<% ArrayList<MemberDTO> list = dao.selectMember();
request.setAttribute("userlist", list);
%>
<jsp:forward page="userlist.jsp"/>

<!-- dao.selectMember(); 호출
ArrayList<MemberDTO>전달받아서
userlist.jsp 전송
forward, request.setAttribute.. 
 -->
 
</body>
</html>