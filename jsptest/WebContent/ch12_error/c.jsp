<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내용은 a.jsp와 같은데, 예외를 b.jsp로 넘기진 않는다.</title>
</head>
<body>

<%
// NumberFormatException 모든 예외를 서버로직에서는 500번 오류로 처리.
int num = Integer.parseInt(request.getParameter("num"));
%>

<h1><%= num * num %></h1>

</body>
</html>