<%@page import="org.json.simple.JSONArray"%>
<%@page import="dto.MemberDTO"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
//id=ajax 이고 pw=ajax 이면 "정상적인 로그인 사용자입니다"
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String result = "";

/* test1: 수동으로 json형식 만들
if(id.equals("ajax") && pw.equals("ajax") ){
	//result = "{\"login\" : true , \"time\" : \"2022-03-08 11:47:50\"}" ;
	SimpleDateFormat sdf =  new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분");
	Date now = new Date();
	String time = sdf.format(now);
	result = "{\"login\" : true , \"time\" : \"" + time + "\"}" ;

}
else{
	result = "{\"login\" : false }" ;
}
*/

// test2 : JSON Object 이용 
// JSON Object: 안에 넣기만 하면 알아서 JSON 형태로 만들어준다. 내부적으로 map 형식, 즉 key, value형식. key는 변수명, value는 사용자가 준 값 
/* 
JSONObject obj = new JSONObject();
if(id.equals("ajax") && pw.equals("ajax") ){
	//result = "{\"login\" : true , \"time\" : \"2022-03-08 11:47:50\"}" ;
	SimpleDateFormat sdf =  new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분");
	Date now = new Date();
	String time = sdf.format(now);
	// map은 삽입할 때 put메서드 
	obj.put("login", true);
	obj.put("time", time);
	// 현재 사용자 정보 
	MemberDTO me = new MemberDTO("ajax", "ajax", "회원1", "010-222-2222", "a@naver.com", "김포");
	obj.put("id", me.getId());
	obj.put("name", me.getName());
	obj.put("phone", me.getPhone());
	obj.put("email", me.getEmail());
	obj.put("address", me.getAddress());
}
else{
	obj.put("login", false);
}
*/
 

// test3 
// 배열로 한 번에 전달.
JSONArray array = new JSONArray();
if(id.equals("ajax") && pw.equals("ajax") ){
	// 다른 회원의 이름 전송
	JSONObject o1 = new JSONObject();
	o1.put("name", "김회원");
	JSONObject o2 = new JSONObject();
	o2.put("name", "박회원");
	JSONObject o3 = new JSONObject();
	o3.put("name", "최회원");
	array.add(o1);	
	array.add(o2);	
	array.add(o3);	
}
else{
	
}
 
%>

<%-- <%=result%> --%>
<%-- <%=obj.toString() %> --%>
<%= array.toString() %>
