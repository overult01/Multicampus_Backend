# Multicampus_Backend
servlet 실습 내용들입니다.

## 1️⃣ servlet
- ch5 서블릿 이해하기
  + 서블릿 API 계층 구조와 기능
  + 서블릿의 생명주기 메서드: init, doGet, destroy
  + 서블릿 동작 과정
  + 애너테이션을 이용한 서블릿 매핑

- ch6: 서블릿 기초
  + 서블릿의 세 가지 기본 기능
  + form태그 이용해 서블릿에 요청하기
  + 서블릿에서 클라이언트의 요청을 얻는 방법: getParameter, getParametValues
  + 서블릿의 응답 처리 방법
  + 웹 브라우저에서 서블릿으로 데이터 전송하기
  + GET 방식과 POST 방식 요청 동시에 처리하기
  + 자바스크립트로 서블릿에 요청하기

- ch7: 서블릿 비즈니스 로직 처리
  + 서블릿의 비즈니스 로직 처리 방법
  + 서블릿의 데이터베이스 연동하기
  + DataSource 이용해 데이터베이스 연동하기
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
14장 표현 언어와 JSTL
14.1 표현 언어란?
14.2 표현 언어 내장 객체(내장 변수)
14.3 표현 언어로 바인딩 속성 출력하기
14.4 커스텀 태그
14.5 JSTL 표준 태그 라이브러리(JSTL)
14.6 Core 태그 라이브러리 사용하기
14.7 Core 태그 라이브러리 실습 예제
14.8 다국어 태그 라이브러리 사용하기
14.9 한글을 아스키 코드로 변환하기
14.10 포매팅 태그 라이브러리 사용하기
14.11 문자열 처리 함수 사용하기
14.12 표현 언어와 JSTL을 이용한 회원 관리 실습

## 4️⃣ Ajax, JSON
- ch 16: HTML5와 제이쿼리
  + 제이쿼리 Ajax 기능
  + 제이쿼리에서 JSON 사용하기

## 5️⃣ Spring framework
- ch18: 스프링 프레임워크 시작하기
18.1 프레임워크란?
18.2 스프링 프레임워크 환경 설정하기

19장 스프링 의존성 주입과 제어 역전 기능
19.1 의존성 주입하기
19.2 의존성 주입 실습하기
19.3 회원 기능 이용해 DI 실습하기

20장 스프링 AOP 기능
20.1 관점 지향 프로그래밍의 등장
20.2 스프링에서 AOP 기능 사용하기

21장 스프링 MVC 기능
21.1 스프링 프레임워크 MVC의 특징
21.2 SimpleUrlController 이용해 스프링 MVC 실습하기
21.3 MultiActionController 이용해 스프링 MVC 실습하기
21.4 MultiActionController 이용해 회원 정보 표시하기
21.5 요청명과 동일한 JSP 이름 표시하기

22장 스프링 JDBC 기능
22.1 스프링 JDBC로 데이터베이스와의 연동 설정하기
22.2 JdbcTemplate 클래스 이용해 회원 정보 조회하기

23장 마이바티스 프레임워크 사용하기
23.1 마이바티스란?
23.2 마이바티스 설치하기
23.3 마이바티스 이용해 회원 기능 실습하기
23.4 마이바티스 이용해 회원 정보 CRUD 실습하기
23.5 마이바티스의 동적 SQL문 사용하기

24장 스프링과 마이바티스 연동하기
24.1 스프링-마이바티스 연동 관련 XML 파일 설정하기
24.2 마이바티스 관련 XML 파일 설정하기
24.3 자바 클래스와 JSP 파일 구현하기

25장 스프링 트랜잭션 기능 사용하기
25.1 트랜잭션 기능
25.2 은행 계좌 이체를 통한 트랜잭션 기능
25.3 스프링의 트랜잭션 속성 알아보기
25.4 스프링 트랜잭션 기능 적용해 계좌 이체 실습하기

26장 스프링 애너테이션 기능
26.1 스프링 애너테이션이란?
26.2 스프링 애너테이션 이용해 URL 요청 실습하기
26.3 스프링 애너테이션 이용해 로그인 기능 구현하기
26.4 @Autowired 애너테이션 이용해 빈 주입하기

27장 메이븐과 스프링 STS 사용법
27.1 메이븐 설치하기
27.2 메이븐 환경 변수 설정하기
27.3 STS 설치하기
27.4 메이븐 프로젝트의 구조 및 구성 요소 살펴보기
27.5 스프링 프로젝트 만들기
27.6 STS 프로젝트 실행하기
27.7 STS 환경에서 마이바티스 실습하기
27.8 log4j 알아보기 9
27.9 타일즈 기능 살펴보기
27.10 JSP 페이지에 타일즈 적용하기
27.11 페이지 본문에 회원 목록창 나타내기
27.12 로그인 기능 구현하기

28장 스프링에서 지원하는 여러 가지 기능
28.1 다중 파일 업로드하기
28.2 썸네일 이미지 사용하기
28.3 스프링 이메일 사용하기
28.4 HTML 형식 메일 보내기
28.5 스프링 인터셉터 사용하기

28.6 인터셉터 사용해 요청명에서 뷰이름 가져오기

29장 스프링 REST API 사용하기
29.1 REST란?
29.2 @RestController 사용하기
29.3 @PathVariable 사용하기
29.4 @RequestBody와 @ResponseBody 사용하기
29.5 REST 방식으로 URI 표현하기

30장 스프링으로 답변형 게시판 만들기
30.1 기존 소스 코드 변경하기
30.2 마이바티스 관련 XML 파일 설정하기
30.3 타일즈 설정하기
30.4 게시판 목록 표시하기
30.5 새 글 추가하기
30.6 글상세창 구현하기
30.7 글 수정하기
30.8 글 삭제하기
30.9 새 글 추가 시 여러 이미지 파일 첨부하기
30.10 글상세창에 여러 이미지 표시하기

31장 도서 쇼핑몰 만들기
31.1 쇼핑몰 애플리케이션 설치하기
31.2 도서 쇼핑몰 기능 알아보기
31.3 메인 페이지 구현하기
31.4 상품 상세 구현하기
31.5 Ajax 이용해 검색 자동 완성 기능 구현하기
31.6 로그인과 회원 가입하기
31.7 장바구니 기능 구현하기
31.8 주문 기능 구현하기
31.9 마이페이지 기능 구현하기
31.10 상품 관리 기능 구현하기
31.11 주문 관리 기능 구현하기

32장 스프링 부트 사용하기
32.1 스프링 부트란?
32.2 스프링 부트 전용 STS 설치하기
32.3 스프링 부트 프로젝트 생성하기
32.4 스프링 부트 프로젝트 실행하기
32.5 스프링 부트 웹 페이지 만들기
32.6 그레이들 이용해 스프링 부트 실습하기
32.7 마이바티스 사용하기
32.8 타일즈 사용하기
32.9 인터셉터 사용하기
