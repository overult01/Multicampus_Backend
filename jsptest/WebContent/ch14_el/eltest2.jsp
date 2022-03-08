<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el내장객체</title>
</head>
<body>

<h1>
<!-- el내장객체 -->
${param.id } 회원님 환영합니다<br>
${param.pw } 암호를 입력하셨습니다<br>
</h1>

<h3>
<%-- ${param.lunch } 1개만 가져옴. --%>
${paramValues.lunch[0] }<br> <!-- paramValues사용하여 인덱싱. 없는 건 알아서 빼고 가져온다.  -->
${paramValues.lunch[1] }<br> <!-- 반복문 사용하고 싶으면 jstl태그를 사용해야. 나중에 다룰 예정. -->
${paramValues.lunch[2] }<br>
${paramValues.lunch[3] }<br>
${paramValues.lunch[4] }<br>

</h3>

<h3>
<!-- 접속하고 있는 서버의 정보 알기
request.getHeader("host")
브라우저 정보 알기
request.getHeader("user-agent")
 -->
서버정보 = ${header.host }<br>
브라우저 정보 = ${header['user-agent']} <br> <!-- 자바 이름 규칙에 어긋나는 변수를 가져올 때는 ['']형식으로 가져온다. -->

</h3>

</body>
</html>