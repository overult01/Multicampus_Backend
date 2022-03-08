<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el로 바인딩 속성 출력(자바객체 -> el전달): jsp내장객체에 값 저장</title>
</head>
<body>


<%
pageContext.setAttribute("i", 1);
request.setAttribute("i", 10);
session.setAttribute("i", 100);
application.setAttribute("i", 1000);
%>

<!-- reqeust, session, application 값만 전달 가능. (pageContext는 현재 페이지의 el과 공유하겠다는 뜻이어서 다른 페이지에 값 전달 불가.) -->
<%-- <jsp:forward page="scope2.jsp"/> --%>

</body>
</html>