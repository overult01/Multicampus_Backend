<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=
request.getParameter("id") + " 관리자님"
%>

<h3>메뉴는 다음과 같습니다.</h3>
<ul>
<!-- start.jsp내 menu에서 전달받은 것으로 li채우기 -->

<%
String[] adminmenu = (String[])request.getAttribute("adminmenu");
for (String m : adminmenu) {
%>

<li><%=m %></li>
<% 
}
%>

</ul>

</body>
</html>