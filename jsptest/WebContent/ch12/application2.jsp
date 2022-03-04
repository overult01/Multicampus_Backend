<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session = "false"
    %>
<!-- session속성은 기본으로 true상태이고, false로만 안하면 된다.     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MemberDTO dto = (MemberDTO)application.getAttribute("app_dto");

%>

<table border = 1>
<tr>
<td><%= dto.getId() %></td><td><%= dto.getName() %></td><td><%= dto.getPhone() %></td>
<td><%= dto.getEmail() %></td><td><%= dto.getAddress() %></td>
</tr>
</table>


</body>
</html>