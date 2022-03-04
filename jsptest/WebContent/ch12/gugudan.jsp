<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp표현문 태그로 출력하기</title>

<style type="text/css">
table{margin: auto; /* 여백을 생각해서 브라우저가 자동으로 오게한다. */}
tr:nth-child(2n){ background-color: gray;}
tr:nth-child(2n+1){ background-color: aqua;}

</style>

</head>
<body>

<table border = 1>
<%
// 사용자 파라미터 2~9 이면 해당 단 출력.
	String dan = request.getParameter("start");
	String dan2 = request.getParameter("end");

	try{
		int startdan = Integer.parseInt(dan);
		int enddan = Integer.parseInt(dan2);
		
		if(startdan >= 2 && startdan <= enddan && enddan <= 9) {
			for(int i = 2; i <= 9; i++) {
%>
<tr>
<%					
			for(int j = startdan; j <= enddan; j++) {
%>					
						<%= "<td>"+	j + "*" + i + "=" + j * i + "</td>" %>
<%
					}
%>					
</tr>
<%					
			}
%>
</table>

<%		
		}
		else { 
%> 
			<%= "출력할 수 없습니다." %>		
<%		}
	
	}
	catch(NumberFormatException e){ %>
			<%= "출력할 수 없습니다." %>		
<%	}

%>



</body>
</html>