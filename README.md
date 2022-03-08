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
![게시판_URL설계](https://user-images.githubusercontent.com/72268581/157219817-c70dfc6d-81f4-4d37-8815-d5ab15d9097b.PNG)

## DB 스키마 구조 
![게시판_DB테이블2](https://user-images.githubusercontent.com/72268581/157216876-9454b044-41b6-4767-bc24-80298872a552.PNG)

## 글 목록, 상세보기, 쓰기, 수정, 삭제 등 기본적인 CRUD 구현
목록 및 페이징
![메인화면](https://user-images.githubusercontent.com/72268581/157225544-c1259a6f-5ba8-4a31-80c5-accb4be13355.PNG)

글 쓰기 
![localhost_8080_board_insert](https://user-images.githubusercontent.com/72268581/157225652-5fc15023-3980-40f9-ab75-013ae9bc940b.png)

![localhost_8080_board_list](https://user-images.githubusercontent.com/72268581/157225771-d8e7a245-cb3c-46c9-a77d-1ae108a1c456.png)

상세보기
![localhost_8080_board_4085](https://user-images.githubusercontent.com/72268581/157226085-49ab23c6-22bb-49ca-98e4-16da6d689e13.png)

수정
![localhost_8080_board_update_4085](https://user-images.githubusercontent.com/72268581/157225914-382c801f-8760-4917-93e1-9ff05681facf.png)

![localhost_8080_board_list (1)](https://user-images.githubusercontent.com/72268581/157225958-36b37891-ef11-4a10-a70a-87b3a8a411e2.png)

삭제
![localhost_8080_board_list (2)](https://user-images.githubusercontent.com/72268581/157226016-791b04d0-2cca-4135-a60d-15e7e912fa39.png)

로그인
![login](https://user-images.githubusercontent.com/72268581/157226784-3db9245f-d792-4f81-b521-1626103bd628.png)
![localhost-8080-board-list](https://user-images.githubusercontent.com/72268581/157226787-fccb79b2-ce3c-4d1d-be35-ebfae248f9a2.png)

검색
![localhost-8080-board-list (1)](https://user-images.githubusercontent.com/72268581/157230288-a83feb39-6e28-47c1-9664-6d624493722c.png)
![localhost-8080-board-list-searchType-title-keyword-안녕하세요](https://user-images.githubusercontent.com/72268581/157230294-a10dc545-3a69-4aca-b8bd-d3ff4d8f496f.png)

댓글
![localhost-8080-board-4083](https://user-images.githubusercontent.com/72268581/157226929-8f6d484b-d2bf-4b74-b70e-4abc13bf4f6d.png)