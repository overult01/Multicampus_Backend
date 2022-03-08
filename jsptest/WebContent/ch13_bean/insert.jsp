<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userBean, setProperty, getProperty세트: 자바 객체를 생성, setter, getter까지 jsp태그로 작성</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>


<!-- 수정필요 -->

<!-- 1. 입력전달  -->
<%-- <%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String email = request.getParameter("email");
String address = request.getParameter("address");
%> --%>



<!-- 자바 문법 대신 Jsp태그로 대체하기
1. 객체생성:  -->
<jsp:useBean id = "dto" class = "dto.MemberDTO" />


<!-- 이 3가지 방법은 모두 같은 기능을 한다. 만약 property의 값과 param의 값이 같으면, param의 값 생략 가능. 
but property 부분과 param부분이 다르면, param부분 생략 불가. html파일 내 input태그 안 name과 property가 같은 경우 생략 가능. 
ex. <jsp:setProperty property= "password" name = "dto" param="pw" />
-->
<%-- <jsp:setProperty property= "id" name = "dto"/>
<jsp:setProperty property= "id" name = "dto" param = "id" />
<jsp:setProperty property= "id" name = "dto" param = "id" value ="<%=request.getParameter("id")%>"/> --%>

<!-- param속성을 사용해서 value = request.getParameter와 동일기능을 한다. 자바 문법이 줄어드는 효과  -->
<%-- <jsp:setProperty property= "password" name = "dto" value ="<%=request.getParameter("pw")%>" /> --%>

<!-- html에서 전달된 파라미터와 dto 변수(property)가 같으면 한 번에 지정  -->
<jsp:setProperty property = "*" name = "dto"/>


<jsp:setProperty property= "password" name = "dto" param="pw" />
<%-- <jsp:setProperty property= "name" name = "dto" />
<jsp:setProperty property= "phone" name = "dto" />
<jsp:setProperty property= "email" name = "dto" />
<jsp:setProperty property= "address" name = "dto" /> --%>



<%-- <jsp:setProperty property= "password" name = "dto" param="pw" />
<jsp:setProperty property= "name" name = "dto" param="name" />
<jsp:setProperty property= "phone" name = "dto" param="phone" />
<jsp:setProperty property= "email" name = "dto" param="email" />
<jsp:setProperty property= "address" name = "dto" param="address" /> --%>

<%-- <jsp:setProperty property= "id" name = "dto" value ="<%=id%>" />
<jsp:setProperty property= "password" name = "dto" value ="<%=pw%>" />
<jsp:setProperty property= "name" name = "dto" value ="<%=name%>" />
<jsp:setProperty property= "phone" name = "dto" value ="<%=phone%>" />
<jsp:setProperty property= "email" name = "dto" value ="<%=email%>" />
<jsp:setProperty property= "address" name = "dto" value ="<%=address%>" /> --%>




<!-- 1. 입력전달 
2. 6개 파라미터들을 MemberDTO객체로 생성
3. db전송
4. 응답
 -->

<!-- 3. db전송 -->
<jsp:useBean id="dao" class = "dao.MemberDAO" />
<%
dao.insertMember(dto);
%>

<!-- 4. 응답: 그대로 출력까지 해준다. --> 
입력한 아이디 : <jsp:getProperty property="id" name="dto"/><br>
입력한 암호 : <jsp:getProperty property="password" name="dto"/><br>
입력한 이름 : <jsp:getProperty property="name" name="dto"/><br>
입력한 폰 : <jsp:getProperty property="phone" name="dto"/><br>
입력한 이메일 : <jsp:getProperty property="email" name="dto"/><br>
입력한 주소 : <jsp:getProperty property="address" name="dto"/><br>
 
</body>
</html>