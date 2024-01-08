Skip to content
jeonmoo
/
shoppingmall

Type / to search

Code
Issues
Pull requests
1
Actions
Projects
Security
Insights
Settings
Create README.md #1
Open
jeonmoo wants to merge 1 commit into master from jeonmoo-patch-1
+36 −0
Conversation 0
Commits 1
Checks 0
Files changed 1
Open
Create README.md
#1
File filter

Create README.md
jeonmoo-patch-1 (#1)
@jeonmoojeonmoo committed 1 minute ago
commit 43e8063d150f0004cb24b5d0aefebffb83b8d76d
36 changes: 36 additions & 0 deletions36  
README.md
@@ -0,0 +1,36 @@
# 👕 의류 쇼핑몰
![image](https://github.com/jeonmoo/shoppingmall/assets/86511348/64133731-2767-4732-a65c-19eedc456763 "메인페이지 이미지")

<!--
테스트 계정
**id : test@test.com**  
**pw : test!@#$**
-->

## 프로젝트 소개
- 이 프로젝트는 일반적인 쇼핑몰을 구현한 개인 프로젝트입니다.
- 이 프로젝트는 상품 구매 ~ 결제(실결제x)단계까지를 기반으로 만들어져 있습니다.
- 일반회원가입을 포함해 카카오, 네이버, 구글 OAuth2 연동이 되어 있습니다.
- 로그인, OAuth2 로그인은 Spring Security를 사용하여 개발 되었습니다.
- 구현 기능으로는 아래와 같습니다.
    - 회원
        - 회원가입, 이메일 중복확인, 로그인
    - 주문
        - 주문등록 (결제전), 결제 (등록주문 결제), 주문조회 (옵션값 : 시작일, 마지막일)
    - 상품
        - 상품등록 (API만), 상품조회 (단건, 리스트)
    - 장바구니
        - 장바구니 등록
    - 리뷰
        - 리뷰작성

## 개발환경
- Front : Thymeleaf, bootstrap5.3, Jquery
- Backend : Java(17), JPA(+ QueryDsl), MapStruct, Lombok
- 버전 관리 : GitHub, GitFlow, 일반적인 커밋 컨벤션 준수

## ERD
![image](https://github.com/jeonmoo/shoppingmall/assets/86511348/07344468-f20a-4963-a107-d3bb850f96f4)

## 기타
- 개발 기간 : 23.11.14 ~ 24.01.05
  Footer
  © 2024 GitHub, Inc.
  Footer navigation
  Terms
  Privacy
  Security
  Status
  Docs
  Contact
  Manage cookies
  Do not share my personal information
  Create README.md by jeonmoo · Pull Request #1 · jeonmoo/shoppingmall 
