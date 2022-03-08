<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습</title>
</head>
<body>

<!-- 1. jstl.html
이름, 나이 입력

2. post 방식으로 jstl2.jsp에 전달

3. jstl2.jsp
이름, 나이 입력되었으면
이름: xxx 가격: xxx 입니다. 

입력된 나이에 따라서 15세 이하면 10000원
16~19면 15000원
20이상이면 이름: xxx님 가격: 20000원 입니다.

나이가 입력되지 않거나, 음수 입력시 계산할 수 없습니다.
이름이 입력되지 않았다면 이름을 확인할 수 없습니다. 
 -->

<%-- ${param.name} 
 
<c:if test="${empty param.name}">
	<h1>이름을 확인할 수 없습니다.</h1>
</c:if>
 --%>
 
<% boolean result = request.getParameter("age").matches("\\d+"); %> 
 
<c:if test="${!empty param.name && !empty param.age }">
	<c:if test="<%= result %>">  <!-- \\d+ : 숫자들만 1개 이상이어야 한다. -->
		<c:choose>
		<c:when test="${param.age <= 15 && param.age >=0 }">
			<h1>이름: ${param.name } 가격: 10000원 입니다.</h1>
		</c:when>
		<c:when test="${param.age <= 19 && param.age >=16 }">
			<h1>이름: ${param.name } 가격: 15000원 입니다.</h1>
		</c:when>
		<c:when test="${param.age >= 20 }">
			<h1>이름: ${param.name } 님 가격: 20000원 입니다.</h1>
		</c:when>
		<c:otherwise>
			<h1>계산할 수 없습니다. </h1>
		</c:otherwise>		
		
		</c:choose>
	</c:if>
</c:if>

<c:if test="${empty param.name}">
		<h1>이름을 확인할 수 없습니다.</h1>
</c:if>

<c:if test="${empty param.age }">
		<h1>계산할 수 없습니다.</h1>
</c:if>
	
		
	
<!-- match(정규표현식)
정규표현식: 자바, 자바스크립트에서 특정 문자열값으로 제한하는 규칙
[구성요소]{얼마나 들어갈 건지 횟수} 

[0-9] === \d : 숫자만.
[0-9A-z]
[0-9A-z가-힣] === \w : 한글, 영문대소문자, 숫자 

\w* : 한글, 영문대소문자, 숫자 // 0개 이상(입력값 없어도 된다) 
\w+ : ..(위와동일)..  // 1개이상
\w{2,5} : ..(위와동일).. // 2~5개 사이 입력

쓸 때는 \\d 로 사용. (\개는 이제 표현식 쓸 거라는 알림용)
-->

<!-- 반복하려는 배열 or Map 객체  -->
<c:forEach items="${paramValues.movie }" var = "m">
	<h1>${m }</h1>
</c:forEach>

<%-- 내 코드 
<c:choose>
	<c:when test="${empty param.name}">
		<h1>이름을 확인할 수 없습니다.</h1>
	</c:when>
	<c:when test="${param.age < 0 || empty param.age }">
		<h1>계산할 수 없습니다.</h1>
	</c:when>
	<c:when test="${param.age < 16 }">
		<h1>이름: ${param.name } 가격: 10000원 입니다.</h1>
	</c:when>
		<c:when test="${param.age < 20 }">
		<h1>이름: ${param.name } 가격: 15000원 입니다.</h1>
	</c:when>
		<c:when test="${20 <= param.age }">
		<h1>이름: ${param.name } 님 가격: 20000원 입니다.</h1>
	</c:when>
	
</c:choose>
 --%>
</body>
</html>