<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
//id=ajax 이고 pw=ajax 이면 "정상적인 로그인 사용자입니다"
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String result = "";

//전체 회원 조회 
JSONArray array = new JSONArray();
if(id.equals("ajax") && pw.equals("ajax") ){

	MemberDAO dao = new MemberDAO();
	ArrayList<MemberDTO> list = dao.selectMember();
	
	for(int i = 0; i <list.size(); i++) {
		 
		MemberDTO dto = list.get(i);
		JSONObject obj = new JSONObject();
	
		obj.put("id", dto.getId()); // 제이쿼리에서 server_response[i].id (put메서드의 1번째 매개변수)
		obj.put("name", dto.getName());
		obj.put("phone", dto.getPhone());
		obj.put("email", dto.getEmail());
		obj.put("address", dto.getAddress());
		array.add(obj);
	}
}
else{
// 회원 리스트 개수 0	
}
 

%>

<%= array.toString() %>