<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp의 주석 3가지: html태그 주석, jsp자체 주석, 자바 주석</title>
</head>
<body>

<!-- html 태그주석: 브라우저 전송되며, 브라우저의 소스보기메뉴에 포함된다(유일) -->
<%-- <% jsp자체 주석이면 서버에서 jsp실행할 때 제외한다. 따라서 브라우저 소스보기에 안나옴.
서버에서 .jsp을 .java로 변환 시점에 주석은 빼버린다.
 %> --%>

<% 
/* 여러줄 주석 */
// 자바의 주석. : 브라우저 소스보기에 안보인다. 서버에서 변환한 .java파일에는 포함되어 있다.
%>

</body>
</html>