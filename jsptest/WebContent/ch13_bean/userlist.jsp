<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList<MemberDTO> list = 
(ArrayList<MemberDTO>)request.getAttribute("userlist"); 

for(MemberDTO dto : list) {
%>
	<%=dto.toString()%>	
<%
}
 %>

</body>
</html>