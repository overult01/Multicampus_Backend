<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp입니다.</h1>
	<h3>현재 서버 시각 출력</h3>
	<h3> <% Date now = new Date();%> <%= now %> </h3>
</body>
</html>