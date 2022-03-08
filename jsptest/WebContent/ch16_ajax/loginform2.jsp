<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax로 로그인 구현 - 클라이언트측 코드</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	$("#ajaxbtn").on('click', function(){
		alert("버튼 클릭");
		requestAjax();
	});//click
});//ready end

		
function requestAjax(){
	$.ajax({
		url:'loginresult2.jsp',
		type:'get',

		/* 	form태그는 자동으로 보내지만 button은 하지 못하므로 명시적으로 보낼 데이터를 적어주기  */		
		data : {'id': $("#id").val() , 'pw':$("#pw").val()}, 
		
		dataType:"json",
		success : function(server_response){  /*  server_response : 성공했을 때 서버로부터 받는 값 */
			
			//방법2(data를 text로 받아왔을 때): JSON.parse(server_response);
			
			//server_response = {"login" : true , "time" : "2022-03-08 11:47:50"}
/* 			if(server_response.login){
				$("#here").html('<h1>' + server_response.time + " 시각에 정상 로그인하셨습니다</h1>");
				$("#here").append("<h3>" + server_response.id + "</h3>"); // 정보 추가
				$("#here").append("<h3>" + server_response.name + "</h3>");
				$("#here").append("<h3>" + server_response.email + "</h3>");
				$("#here").append("<h3>" + server_response.address + "</h3>");
				
				$("#here").css("color", "green");
			}
			//{"login" : false }
			else{
				$("#here").html('<h1> 로그인 정보를 확인하세요 </h1>');
				$("#here").css("color", "red");	

			} */
			
			
			// 배열로 받아왔을 때 
			alert(server_response.length);
			for(var i = 0; i < server_response.length; i++) {
				$("#here").append("<h3>" + server_response[i].name +"</h3>");
			}
			$("#here").css("color", "green");			
		},
		error : function(err){ /*  err: 실패했을 때 서버로부터 받는 값  */
			alert(err);
		}
	});//ajax end
	
}//requestAjax end
</script>
</head>
<body>
<h1>로그인폼</h1>
<form action="loginresult2.jsp" method="post" >
아이디:<input type=text id="id" name="id"><br>
암호:<input type="password" id="pw" name="pw"><br>
<input type=submit value="동기적통신로그인">
<input type=button id="ajaxbtn" value="비동기적통신로그인">
</form>
<div id="here"></div>
<h3>로그인 결과는 윗줄에 출력 예정입니다.</h3>
</body>
</html>