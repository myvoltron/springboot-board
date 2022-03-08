# springboot-board

간단한 스프링부트 게시판입니다. 

## 사용된 기술들
- RDBMS : MySQL 
- frontend : HTML, CSS, JavaScript, Spring Boot의 템플릿 언어인 Thymeleaf(추가적으로 레이아웃 기능도 사용함)
- backend : Spring Boot
- others : lombok, Mybatis 등...

## 게시판의 주요 기능
- 글 목록, 상세보기, 쓰기, 수정, 삭제 등 기본적인 CRUD 구현
- 회원 목록, 상세보기, 가입, 수정, 삭제 그리고 로그인, 로그아웃 기능 구현
- 로그인을 하지 않은 상태에선 view의 header 부분에 로그인, 회원가입 버튼이 보이게 됨
- 로그인을 한 상태에선 view의 header 부분에 로그아웃 버튼이 보이게 됨
- 페이징 : 한 페이지에 10개의 글 출력, 페이지 블럭은 5개로 제한
- 검색 기능 : HTML select 기능으로 제목검색과 내용검색을 할 수 있다. 
- 댓글 기능

## URL 설계 

## DB 스키마 구조 