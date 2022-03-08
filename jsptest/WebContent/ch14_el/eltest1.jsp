<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el문법-기본형태</title>
</head>
<body>


<%-- ${el 표현 문법 } script태그 안에 있는 문법은 제이쿼리 --%>
<!-- el 자료형  -->
${true}<br>
${100}<br>
${100.99}<br>
${'문자열1' }<br>

${"문자열2" }<br>
${null}<br> <!-- null만 출력되지 않는다. el은 null을 만나면 출력을 무시해서 공백으로 만들어줌. -->


<!-- el연산자. 표현식을 그대로 출력하려면 \붙이기.  -->
\${100+1 } = ${100+1 }<br>  <%-- ${100+1 } = 101 --%>
\${'100'+1 } = ${'100'+1 }<br> <!-- 자바에서는 1001. el에서는 101(정수 100으로 취급). 즉, 따옴표 안에 숫자라면 형변환 필요없다. -->
<%-- \${'백'+1 } = ${'백'+1 }<br> --%> <!-- 실행불가. 형변환이 될 수 없는 건 숫자와 더하기 불가. -->
\${'백'+= 1 } = ${'백'+= 1 }<br> <!-- ${'백'+= 1 } = 백1. 문자열 결합을 할 때는 += 을 사용. -->
\${null + 1 } = ${null + 1 }<br> <!-- null은 숫자와 +시 0으로 취급. cf. null을 그냥 출력하면 공백 취급  -->

\${10 /2 } = ${10 / 2 }<br> <!-- ${10 /2 } = 5.0 . 실수몫  -->
\${10 /2 } = ${10 div2 }<br>
\${10%3 } = ${10 % 3 } <br>
\${10%3 } = ${10 mod 3 } <br>


<!-- 비교연산  -->
\${10 > 3 } = ${10 > 3 } <br> <!-- true -->
\${10 > 3 } = ${10 gt 3 } <br> <!-- true -->

\${10 > 3 } = ${10 < 3 } <br> <!-- false -->
\${10 > 3 } = ${10 lt 3 } <br> <!-- false -->
\${10 == 3 } = ${10 eq 3 } <br> <!-- false -->
\${10 != 3 } = ${10 != 3 } <br> <!-- nq 은 != true -->


<!-- 논리연산 &&, ||, ! 그대로 사용. -->

<!-- +=: 문자열 결합 연산자. +: 오로지 산술 연산만 가능. -->

<!-- empty연산자: null인지 체크  -->
${null }<br>  <!-- 공백 출력  -->
${empty null }<br> <!-- true. empty뒤의 변수가 null이니  -->
${!empty null }<br> <!-- false. null이 아닌지  -->
${empty null?"null입니다":"null아닙니다" }<br> <!--  null입니다. 조건삼항 연산자와 empty연산자 --> 

<!-- 자바문장을 el로 표현하기
String id = request.getParameter(id);
id.equals("java"); -->
파라미터 값 출력 = ${empty param.id?"id를 입력하세요":param.id}  <!-- param.id: 자바의 request.getParameter(id) 와 동일-->



</body>
</html>