<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage = "true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>isErrorPage = "true" 인 jsp에서만, exception처리가능 </title>
</head>
<body>

<h1>=======toString 내용(브라우저 출력)=======</h1>
<%= exception.toString() %>

<h1>=======getMessage 내용(브라우저 출력)=======</h1>
<%= exception.getMessage() %>

<h1>=======printStackTracee 내용(콘솔 출력)=======</h1>
<% exception.printStackTrace(); %>


</body>
</html>
