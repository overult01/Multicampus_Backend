<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include디렉티브 태그로 jsp파일 1개를 공유하기: 코드 재사용, 화면 통일성</title>
</head>
<body>

<h1>쇼핑리스트를 보여줄 화면입니다.</h1>

<%
String image = request.getParameter("image");
%>

<!-- include디렉티브 태그 -->
<h2>======include directive tag(정적 include)=======</h2>
<%@ include file = "footer.jsp" %>

<!-- include action태그  -->
<h2>======include action tag(동적 include: 데이터 추가전달 가능.)=======</h2>

<!-- 객체를 전달하고 싶을 때. 읽어올 때는 request.getAttribute를 쓰면 된다. -->
<% request.setAttribute("dto",
		new MemberDTO("INCLUDE", "1234", "포함", "01010111", "Email", "주소")
		); %>

<jsp:include page = "footer.jsp" >
	<!-- 동적으로 include를 추가할 수 있게 되었다. -->
<!-- 	일반적인 텍스트 일때. 읽어 올 때 request.get -->
<!-- jsp:param 태그: jsp:include태그 쪽으로 동적으로 추가하고 싶을 때. include태그 안에 포함되어 있음. -->

	<jsp:param value="drinks.jpg" name="image"/>
		
</jsp:include>

</body>
</html>