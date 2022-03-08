<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= request.getParameter("id") + " 회원님 메뉴는 다음과 같습니다." %>

<ul>
<%
String[] usermenu = (String[])request.getAttribute("usermenu");
for (int i = 0; i < usermenu.length; i++) {
%>

<li><%= (i+1) + "번째 메뉴" + usermenu[i] %></li>
<% 
}
%>

<!-- start.jsp내 menu에서 전달받은 것으로 li채우기 -->


<li>내정보 관리</li>
<li>내글 관리</li>
<li>구입상품 관리</li>
</ul>
</body>
</html>