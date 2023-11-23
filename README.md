# SpringBoot-Project-ShoppingMall
스프링 부트 + Vue.js를 활용한 야구 굿즈 쇼핑몰 사이트


## 📖 프로젝트 소개
NC 다이노스 팀스토어를 참고하여 만든 야구 굿즈 쇼핑몰 사이트입니다.
<br>

## ⏳ 개발 기간
* 23.11.15 ~ 23.11.24

### 🧑‍🤝‍🧑 맴버구성
 - 팀장  : 이호진 - DataBase 설계, 웹 페이지 개발
 - 팀원  : 최다희 - DataBase 설계, 제작 및 관리, 서버 로직 개발

### ⚙️ 개발 환경
- `Java 8`
- `JDK 1.8.0`
- **IDE** : STS 3.9
- **Framework** : Springboot(2.x)
- **Database** : My SQL(8.x)
- **ORM** : Mybatis(2.x)

## 📌 주요 기능
#### 로그인 / 회원가입 - <a href="https://github.com/HeeHiHee/adhd_back/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Login,-SignUp)">상세보기 - WIKI 이동</a>
- 로그인 시 JWT방식으로 DB값 검증
- 회원가입 시 아이디, 닉네임 중복 검사
- 정지 회원, 탈퇴 회원은 로그인 불가능

#### 마이 페이지 - <a href="https://github.com/HeeHiHee/adhd_back/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(MyPage)">상세보기 - WIKI 이동</a>
- 주소 API 연동
- 회원정보 변경, 탈퇴
- 배송지 관리(CRUD)
- 리뷰, 문의사항 확인(RUD)
- 찜, 장바구니 목록
- 주문내역
- 공지사항

#### 메인 페이지 - <a href="https://github.com/HeeHiHee/adhd_back/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Main-Page)">상세보기 - WIKI 이동</a>
- Youtube API 연동
- 새 상품 리스트
- 인기상품 리스트 

#### 상품 페이지 - <a href="https://github.com/HeeHiHee/adhd_back/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Product-Page)">상세보기 - WIKI 이동</a>
- 상품 카테고리 별 상품 리스트
- 상품 상세 페이지

#### 상품 구매 - <a href="https://github.com/HeeHiHee/adhd_back/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Order)">상세보기 - WIKI 이동</a>
- 상품 사이즈, 옵션, 수량 선택
- 장바구니 등록
- 구매 페이지 

#### 관리자 페이지 
- 고객 문의사항 답변(CRUD)
- 회원 관리 (회원 정지)
- 공지사항, 이벤트(CRUD)
