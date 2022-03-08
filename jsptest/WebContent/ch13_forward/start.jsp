<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String id = request.getParameter("id");
String path = "";
if(id.equalsIgnoreCase("super") || id.equalsIgnoreCase("admin")){
	String[] menu = {"사용자관리", "게시판관리", "상품관리", "결제관리", "배송관리"};
	path = "admin.jsp";
	// menu 배열을 admin.jsp 이동시 같이 전달 
	request.setAttribute("adminmenu", menu);
}
else {
	String[] menu = {"내정보관리", "내글관리", "구입상품관리"};
	// menu 배열을 user.jsp 이동시 같이 전달 
	path = "user.jsp";
	request.setAttribute("usermenu", menu);
}

%>

<%= "출력하려해도 무시된다:forward전" %>

<!-- path에 jsp, 서블릿 올 수 있다. -->
<jsp:forward page= "<%=path%>" />

<%= "출력하려해도 무시된다:forward후" %>

</body>
</html>