<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
//ajax통신시 서버측 코드
//ajax통신시 출력되는 모든 형태는 json이어야.
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String result = "";
if(id.equals("ajax") && pw.equals("ajax") ){
	result = "{\"login\" : true , \"time\" : \"2022-03-08 11:47:50\"}" ;


}
else{
	result = "{\"login\" : false }" ;
}
%>
<%=result%>