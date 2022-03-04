<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체: PageContext는 다른 내장객체 전달해준다.</title>
</head>
<body>
<%! public void multiply(PageContext p, int i, int j) throws IOException{
	// 원래 jsp의 내장 객체는 사용자 정의 메서드에서는 사용 불가.
	// 이 메서드 안에 내장 객체 쓰려고 PageContext라는 내장객체를 사용한 것. 
	p.getOut().println(i + "*" + j + "=" + i * j);
	}
	%>

<% 
// _jspService 메서드 문장 
pageContext.getOut(); // Out 내장객체 사용하기 
try{
	multiply(pageContext, 10, 20);	
}
catch(IOException e){
	
}
%>

</body>
</html>