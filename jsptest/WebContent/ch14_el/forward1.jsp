<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el: 화면에 출력해주는 표현을 간결하게. 주로 getter메서드 역할을 한다.</title>
</head>
<body>
특정 아이디를 가진 회원의 주소값 저장 -> forward2.jsp로 이동, 전달
<% String id = "member";
// member 회원의 정보를 db select해서 address 컬럼의 값을 가져왔다.
	String address = "서울시 역삼동";
	request.setAttribute("id", id);
	request.setAttribute("address", address);
	MemberDTO dto = new MemberDTO("멤버", "1234", "김회원", "010-222-1111", "kim@a.com", "null");
	request.setAttribute("member_info", dto);
%>

<jsp:forward page="forward2.jsp" />


</body>
</html>