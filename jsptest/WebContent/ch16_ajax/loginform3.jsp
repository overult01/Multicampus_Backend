<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax로 로그인 구현, DB연동 - 클라이언트측 코드</title>
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

	$("#alluserbtn").on('click', function(){
		alert("전체 회원 조회 버튼 클릭");
		requestAjax2();
	});//click
});//ready end
		
		
// 로그인 메서드 		
function requestAjax(){
	$.ajax({
		url:'loginresult2.jsp',
		type:'get',

		// 서버로 보내는 부분
		/* 	form태그는 자동으로 보내지만 button은 하지 못하므로 명시적으로 보낼 데이터를 적어주기  */		
		data : {'id': $("#id").val(), 
			'pw':$("#pw").val(),
			},
		
			
		// 서버로부터 데이터 받아올 때 :server_response에 배열, 객체 로 받아올 수 있다.
		dataType:"json",
		success : function(server_response){  /*  server_response : 성공했을 때 서버로부터 받는 값 */
				
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


// 전체 회원 조회 메서드(DB에서 가져오기)
function requestAjax2(){
	$.ajax({
		url: 'loginresult3.jsp',
		type: 'get',
		
		data : {'id': $("#id").val(), 
			'pw':$("#pw").val(),
			},
			
		dataType:"json",
		success : function(server_response){  // 여기선 배열
					
			// 배열로 받아왔을 때 
			alert(server_response.length);
			
			$('#alluserdiv').html("<table border=3>");
		
			for(var i = 0; i < server_response.length; i++) {
				$("#alluserdiv").append(
						"<tr>" 
						+"<td>" + server_response[i].id + "</td>"
						+"<td>" + server_response[i].name + "</td>" 
						+"<td>" + server_response[i].phone + "</td>"
						+"<td>" + server_response[i].email + "</td>"
						+"<td>" + server_response[i].address + "</td>"
						+"</tr>");
			}
			$('#alluserdiv').append("</table");
		},
		error : function(err){ /*  err: 실패했을 때 서버로부터 받는 값  */
			alert(err);
		}		
	})
}

</script>
</head>
<body>
<h1>로그인폼</h1>
아이디:<input type=text id="id" name="id"><br>
암호:<input type="password" id="pw" name="pw"><br>
<input type=button id="ajaxbtn" value="비동기적통신로그인">
<input type=button id="alluserbtn" value="회원리스트보기">

<div id="here"></div>
<div id="alluserdiv" style = "border:2px solid pink; width: 800px; height: 800px; overflow: hidden;"></div>
</body>
</html>