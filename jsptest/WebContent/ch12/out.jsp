<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    buffer="1kb"
    autoFlush="true"
    %>
<!-- buffer: 저장할 공간. 안써도 기본값이 8kb.
1. 서버 내부에 jsp파일을 버퍼라는 공간에 임시저장. 만약 버퍼크기를 넘어서면 일부를 전송하고, 버퍼를 비워두고 사용한다. buffer flush.
2. 클라이언트에 전송.
이렇게 서버 내부에 임시로 저장하는 이유는 클라이언트 전송 전에 예외상황 생길까봐.     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= "총 버퍼크기(위에서 지정한 값. 기본8kb) : " + out.getBufferSize() %>
<%= "남아있는 버퍼크기1(출력위치에 따라 달라진다.) : " + out.getRemaining() %>

<!-- 자바에서 출력  -->
<%
String name = request.getParameter("name");
out.println(name);
out.flush(); // 버퍼 비우는 것.
%>
<br>

<!-- jsp 표현식 태그로 출력  -->
<%= name %>
<br>

<!-- jsp표현식 태그를 입력값으로 받기  -->
사용자 입력값: <input type = text value = <%= name %> >

<%= "남아있는 버퍼크기2(출력위치에 따라 달라진다.) : " + out.getRemaining() %>

</body>
</html>