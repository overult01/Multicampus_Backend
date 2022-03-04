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
MemberDTO dto = (MemberDTO)request.getAttribute("dto");

%>

<table border = 1>
<tr>
<td><%= dto.getId() %></td><td><%= dto.getName() %></td><td><%= dto.getPhone() %></td>
<td><%= dto.getEmail() %></td><td><%= dto.getAddress() %></td>
</tr>
</table>


</body>
</html>