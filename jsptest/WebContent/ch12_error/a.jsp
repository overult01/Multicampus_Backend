<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage = "b.jsp"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지로 에러처리 넘기기: errorPage</title>
</head>
<body>

<%
int num = Integer.parseInt(request.getParameter("num"));
%>

<h1><%= num * num %></h1>

</body>
</html>