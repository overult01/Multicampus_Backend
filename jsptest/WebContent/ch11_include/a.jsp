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
<!-- include디렉티브 태그 -->
<%@ include file = "footer.jsp" %>

</body>
</html>