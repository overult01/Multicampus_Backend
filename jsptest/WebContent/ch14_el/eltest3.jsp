<%@page import="java.util.HashMap"%>
<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext객체: 1개 jsp파일 내에서 자바문장, el문장의 데이터 전달</title>
</head>
<body>
jsp 내 자바 문장 
<% int i = 10; %>

jsp내 el 언어(한 개의 jsp 파일이지만, 서로 다른 언어로 인식)
i = ${i} 입니다.라고 해도 위의 자바 표현식을 인식하지 못해서 i를 못받아온다. <br>


<!-- pageContext 역할:1. 다른 내장 객체를 사용할 수 있게 해준다. 2.(여기 예시 해당) 현재 페이지의 el변수를 사용할 수 있게 해준다.
 -->
<% int i2 = 10;
pageContext.setAttribute("ii", i); // 현재 페이지 안에서 el과 자바 변수 간의 데이터 전달이 가능.

// request.setAttribute("ii", i);

%>
i2 = <%= i2 %><br>
i2 = ${ii }입니다. el에서 자바변수 사용하기.<br>

<!-- jsp 액션 태그  -->
<jsp:useBean id="dto" class = "dto.MemberDTO" /> <!-- 객체 생성  -->
<jsp:setProperty property="id" name="dto" value="eltest"/> <!-- id 값의 value지정  -->

<!-- 모든 el은 setter역할을 할 수 없다. 오로지 가져오는 getter만  -->
dto 객체 id 값 = ${dto.id }<br>  <!-- dto 객체 id 값 = eltest -->

<hr>

Collection 객체
1. 배열 ArrayList 타입의 자바객체(인덱스 순서대로 관리)를 el전달. 
<% 
	String array[] = {"red", "black", "white", "green", "blue"};
	for(int j = 0; j < array.length; j++) {
		out.println(array[j] + "<br>");
	}
	
/* 	el에 전달해주기 위해  */
	pageContext.setAttribute("cols", array);
%>

${cols[0] }<br>
${cols[1] }<br>
${cols[2] }<br>
${cols[3] }<br>
${cols[4] }<br>

<hr>
<% 
ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); 
list.add(new MemberDTO("MEM1", "1", "회원1", "폰1", "이메일1", "주소1"));
list.add(new MemberDTO("MEM2", "2", "회원2", "폰2", "이메일2", "주소2"));
list.add(new MemberDTO("MEM3", "3", "회원3", "폰3", "이메일3", "주소3"));
list.add(new MemberDTO("MEM4", "4", "회원4", "폰4", "이메일4", "주소4"));
list.add(dto); // <jsp:useBean id = "dto" ..>
/* el로 전송  */
pageContext.setAttribute("memberlist", list);
%>

${memberlist[0].id } - ${memberlist[0].name} - ${memberlist[0].email}<br>  <!-- el에서는 getter메서드의 get을 빼고 변수로 가져와야  -->
${memberlist[1].id } - ${memberlist[1].name} - ${memberlist[1].email}<br>
${memberlist[2].id } - ${memberlist[2].name} - ${memberlist[2].email}<br>
${memberlist[3].id } - ${memberlist[3].name} - ${memberlist[3].email}<br>

2. map타입(key, value의 쌍)의 자바 객체를 el에 전달.
<% 
HashMap<String, String> map = new HashMap<String, String>(); 
map.put("빨강색", "red");
map.put("초록색", "green");
map.put("파란색", "blue");
map.put("검정색", "black");
map.put("흰색", "white");
/* el로 전송 */
pageContext.setAttribute("colmap", map);
%>

<!-- prefix는 jstl을 무엇으로 부를지 정하는 것. 일반적으로 c라고 많이 쓴다.-->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!-- colmap에 있는 데이터 만큼 반복하라  -->
<c:forEach items="${colmap }" var = "col">
	${col.key } - ${col.value }<br>
</c:forEach>
	
<%-- ${map.빨강색 }<br> : el에선 한글 key 바로 출력 불가--%>
<!-- $map['빨강색'] <br> -->
map은 반복문으로 출력 필요.
el은 반복문이 없어서 jstl 반복문 사용 
${map.key } - ${map.value }<br>



</body>
</html>