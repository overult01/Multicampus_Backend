<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지역변수, 서블릿변수</title>
</head>
<body>


<!-- 412~414	페이지 참고  -->

<% 	// _jspService메서드 내부의 내용으로 들어간다. 
	String local = "지역변수입니다.";
	out.println(local + ":" + member);
	String result = test();
	out.println(result);
%>

<%!
String member = "멤버변수입니다.";
// 우리가 만든 메서드 
public String test(){
	// local이 지역변수이기 때문에 메서드 안에서 사용 불가.
/* 	System.out.println(local); */
	return member;
}
%>

</body>
</html>