<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el로 바인딩 속성 출력(자바객체 -> el전달):xxxScope과 우선순위 or 내장객체 이름 명시</title>
</head>
<body>

<%= pageContext.getAttribute("i") %>
<%= request.getAttribute("i") %>
<%= session.getAttribute("i") %>
<%= application.getAttribute("i") %>
<!-- null null 1 1 -->

<%-- <jsp:forward page="scope2.jsp"/> 가 추가된 후 
request의 10도 받음. null 10 100 1000 --%>
<br>
현재 페이지에서 전달 받은 값 = ${i }<br> <!-- 우선순위가 가장 높은 pageScope에서 먼저 찾고 없어서, 그 다음 우선순위 request에서 찾는다. -->
<!-- 변수이름만 썼을 때 우선순위 : 1. pageContext 2. request 3. session 4. application  -->
요청 객체에서 전달받은 값 = ${requestScope.i }<br>
<!-- 10 -->

세션 객체에서 전달받은 값 = ${sessionScope.i }<br>
어플리케이션 객체에서 전달받은 값 = ${applicationScope.i }<br>
</body>
</html>