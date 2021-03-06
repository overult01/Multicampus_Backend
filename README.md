# Multicampus_Backend
servlet, JSP, AJAX 실습 내용들입니다.

- [웹 프로그래밍 개발 기초 기념](https://structuring.tistory.com/185?category=987699)
- [웹 애플리케이션 이해](https://structuring.tistory.com/186?category=987699)

## 1️⃣ servlet
- [ch5 서블릿 이해하기](https://structuring.tistory.com/187?category=987699)
  + 서블릿 API 계층 구조와 기능
  + [서블릿의 생명주기 메서드: init, doGet, destroy](https://structuring.tistory.com/189?category=987699)
  + [서블릿 동작 과정](https://structuring.tistory.com/188?category=987699)
  + 애너테이션을 이용한 서블릿 매핑

- ch6: 서블릿 기초
  + [서블릿의 세 가지 기본 기능, 요청과 응답](https://structuring.tistory.com/190?category=987699)
  + [form태그 이용해 서블릿에 요청하기](https://structuring.tistory.com/191?category=987699)
  + 서블릿에서 클라이언트의 요청을 얻는 방법: getParameter, getParametValues
  + 서블릿의 응답 처리 방법
  + 웹 브라우저에서 서블릿으로 데이터 전송하기
  + GET 방식과 POST 방식 요청 동시에 처리하기
  + 자바스크립트로 서블릿에 요청하기

- ch7: 서블릿 비즈니스 로직 처리
  + 서블릿의 비즈니스 로직 처리 방법
  + [서블릿의 데이터베이스 연동하기](https://structuring.tistory.com/192?category=987699)
  + [DataSource 이용해 데이터베이스 연동하기](https://structuring.tistory.com/193?category=987699)
  + DataSource 이용해 회원 정보 등록하기
  + 회원 정보 삭제하기

- ch8: 서블릿 확장 API 사용하기
  + 서블릿 포워드 기능 사용하기
  + 서블릿의 여러 가지 포워드 방법
  + dispatch를 이용한 포워드 방법
  + 바인딩
  + ServletContext와 ServletConfig 사용법
  + load-on-startup 기능 사용하기

- ch9: 쿠키와 세션 알아보기
  + 웹 페이지 연결 기능
  + [hidden] 태그와 URL Rewriting 이용해 웹 페이지 연동하기
  + 쿠키를 이용한 웹 페이지 연동 기능
  + 세션을 이용한 웹 페이지 연동 기능
  + encodeURL( ) 사용법
  + 세션을 이용한 로그인 예제

- ch10: 서블릿의 필터와 리스너 기능
  + 서블릿 속성과 스코프
  + 서블릿의 여러 가지 URL 패턴
  + Filter API
  + 여러 가지 서블릿 관련 Listener API


## 2️⃣ JSP
- ch11: JSP 정의와 구성 요소
  + JSP의 3단계 작업 과정
  + JSP 페이지 구성 요소
  + 디렉티브 태그

- ch12: JSP 스크립트 요소 기능
  + JSP 스크립트 요소
  + 선언문 사용하기
  + 스크립트릿 사용하기
  + 표현식 사용하기
  + 내장 객체(내장 변수) 기능
  + JSP 페이지 예외 처리하기
  + JSP welcome 파일 지정하기
  + 스크립트 요소 이용해 회원 정보 조회하기

- ch13: 자바 코드를 없애는 액션 태그
  + 인클루드 액션 태그 사용하기
  + 포워드 액션 태그 사용하기
  + useBean, setProperty, getProperty 액션 태그 사용하기

## 3️⃣ EL, JSTL
- ch14: 표현 언어와 JSTL
  + 표현 언어란?
  + 표현 언어 내장 객체(내장 변수)
  + 표현 언어로 바인딩 속성 출력하기
  + 커스텀 태그
  + JSTL 표준 태그 라이브러리(JSTL)
  + Core 태그 라이브러리 사용하기
  + 한글을 아스키 코드로 변환하기
  + 포매팅 태그 라이브러리 사용하기
  + 문자열 처리 함수 사용하기

## 4️⃣ Ajax, JSON
- ch 16: HTML5와 제이쿼리
  + 제이쿼리 Ajax 기능
  + 제이쿼리에서 JSON 사용하기
