<%@page import="java.util.HashMap"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
// MemberDTO 객체 3개 생성하여 HashMap에 저장 - key(dto id값), value(dto 객체)

MemberDTO dto1 = new MemberDTO("member1", "1", "멤버1", "01011112222","mem1@email.com", "서울");
MemberDTO dto2 = new MemberDTO("member2", "1", "멤버2", "01022222222","mem2@email.com", "부산");
MemberDTO dto3 = new MemberDTO("member3", "1", "멤버3", "01033332222","mem3@email.com", "광주");

HashMap<String, MemberDTO> memberMap = new HashMap();

memberMap.put(dto1.getId(), dto1);
memberMap.put(dto2.getId(), dto2);
memberMap.put(dto3.getId(), dto3);

pageContext.setAttribute("memberMap", memberMap);
%>

<c:forEach items="${memberMap }" var = "dto" varStatus = "vs"> <!-- varStatus: 반복상태정보  -->
	${vs.index}번째 회원 조회중 - ${dto.key } - ${dto.value.address }<br>
	${vs.count}번째 회원 조회중 - ${vs.current.key } - ${vs.current.value.address }<br> <!-- dto.key == vs.current.key -->
</c:forEach>

</body>
</html>