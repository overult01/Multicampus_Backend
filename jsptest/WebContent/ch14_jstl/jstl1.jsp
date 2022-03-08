<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c태그의 set(변수정의), remove(변수 삭제)</title>
</head>
<body>

<% String jspvar = "자바변수"; %>

c태그(= jstl)에서 변수 선언: el에서는 타입 지정 없이 자동으로 인식해서 타입지정해준다.
<c:set var = "i" value = "100"></c:set>
<c:set var = "j" value = "문자열"></c:set>
<!-- 다른 el변수에 연산도 할 수 있다.  -->
<c:set var = "k" value = "${i+200 }"></c:set><!--  이미 만들어진 el 변수를 값으로 넣기  -->
<c:set var = "m" value = "<%= jspvar + \"추가\" %>"></c:set> <!-- 자바로 만들어진 변수를 표현문 태그로 가져옴  -->


<!-- el 출력(표현) -->
<h3>${i }</h3>
<h3>${j }</h3>
<h3>${k }</h3>
<h3>${m }</h3>

<!-- 100
문자열
100
자바변수 -->

변수 삭제 : c의 remove 태그 
<c:remove var="i"/>
<h3>${i }</h3>

조건문 : c의 if. 조건문 내부는 반드시 el표현식을 써야. else문이 없다. 따라서 따로 !를 붙여서 따로 else처리를 해줘야.
<c:if test="${empty i }">
	<h1>i는 더이상 사용 불가능합니다.</h1>
</c:if>
<c:if test="${!empty i }">
	<h1>i는 계속 사용 가능합니다.</h1>
</c:if>


<!-- jstl1.jsp?id=test&password = 1234실행했을 때
id admin이고, password 1234이면 관리자입니다. 표현 
id admin아니고, password 1234이면 일반 사용자입니다. 표현 
사용자 입력값 el로 받아올 때는 ${param.id }
 -->

<hr>

 <!-- if블록 해당 -->
<%-- <c:if test="${param.password == '1234'}">
	<c:if test="${param.id == 'admin'}">
		<h1>관리자입니다 </h1>
	</c:if>

	<c:if test="${param.id != 'admin'}">
		<h1>일반사용자입니다 </h1>
	</c:if>
</c:if>
<c:if test="${param.password != '1234'}">
	<h1>암호를 다시 입력하세요</h1>
</c:if> --%>

<!-- switch-case 블록 해당 -->
<c:choose>
	<c:when test="${param.id == 'dbadmin' }">
		<h1>db관리자입니다.</h1>
	</c:when>
	<c:when test="${param.id == 'webadmin' }">
		<h1>서버관리자입니다.</h1>
	</c:when>
	<c:when test="${param.id == 'admin' }">
		<h1>총괄관리자입니다.</h1>
	</c:when>
	<c:otherwise> <!-- else역할: 그 외의 것이라는 뜻. if문은 아니지만  -->
		<h1>관리자가 아닙니다.</h1>
	</c:otherwise>
</c:choose>

${"java" }

<!-- 포함여부 확인  -->
<!-- String은 자바 객체중에서 유일하게 객체 생성이 필요 없는 타입. 따라서 el에서 String 타입의 메서드 사용 가능. -->
<!-- param.id은 String 타입. 따라서 param.id.String타입내 메서드 사용가능. 
contains, indexOf 는 String 타입 내 메서드-->
contains: admin 포함 여부(t/f) = ${param.id.contains("admin") }<br>
indexOf: admin 포함 여부(위치) = ${param.id.indexOf("admin") }<br>
indexOf: admin 포함 여부 = ${param.id.indexOf("admin") >=0 }<br> <!-- 없으면 -1니까 false  -->

같은지 = ${param.id == "admin"}<br>
같은지(대소문자 무시) = ${param.id.equalsIgnoreCase("admin")}<br>




</body>
</html>