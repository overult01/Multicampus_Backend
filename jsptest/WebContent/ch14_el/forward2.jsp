<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현문 태그와 el태그의 getter방법 비교</title>
</head>
<body>

<!-- 표현문 태그로 가져오는 방법  -->
<h1 style=color:green>
<%= request.getAttribute("id") %> 님의 주소는 
<%= request.getAttribute("address") %> 입니다.<br>
<%= ((MemberDTO)request.getAttribute("member_info")).getId() %> <!-- 리턴타입은 Object. 따라서 원래 타입인 MemberDTO로 형변환 필요. -->
<%= ((MemberDTO)request.getAttribute("member_info")).getName() %>
없는 값을 가져오라고 한다면 실행이 아예 불가.
<%-- <%= ((MemberDTO)request.getAttribute("member_info")).getBirth() %> --%>
있는 메서드지만, 객체에서 준 값이 null일 때. null출력. 
<%= ((MemberDTO)request.getAttribute("member_info")).getAddress() %> 
</h1>

<!-- el으로 가져오는 방법(위와 동일한 결과) -->
<h1 style=color:blue>
${id }님의 주소는 ${address }입니다.
${member_info.id } <!-- 객체.  -->
${member_info.name }
<%-- ${member_info.birth }  --%><!-- el은 내부적으로 getBirth를 찾는데 없어서 PropertyNotFoundException에러 발생 -->
${member_info.address } <!-- 값이 null일 때 공백 출력  -->
${member_info } <!-- 객체는 그냥 호출하면 toString메서드 호출과 같다.  -->


</h1>

</body>
</html>