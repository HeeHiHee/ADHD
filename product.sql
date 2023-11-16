CREATE DATABASE adhd;
use adhd;

-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`Product` (
  `productId` INT NOT NULL AUTO_INCREMENT,
  `categoryId` INT NOT NULL,
  `productName` VARCHAR(45) NOT NULL,
  `cost` INT NOT NULL,
  `price` INT NOT NULL,
  `profit` INT NOT NULL,
  `productImg` VARCHAR(400) NOT NULL,
  `productInfoImg` VARCHAR(400) NOT NULL,
  `soldOut` TINYINT NOT NULL,
  `regDate` TIMESTAMP NOT NULL,
  `orderCnt` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`productId`),
  UNIQUE INDEX `productId_UNIQUE` (`productId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adhd`.`ProductCategory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`ProductCategory` (
  `categoryId` INT NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(45) NOT NULL,
  `level` INT NOT NULL,
  `parentCategoryId` INT NOT NULL,
  PRIMARY KEY (`categoryId`),
  UNIQUE INDEX `categoryId_UNIQUE` (`categoryId` ASC) VISIBLE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `adhd`.`ProductSize`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`ProductSize` (
  `productSizeId` INT NOT NULL AUTO_INCREMENT,
  `productId` INT NOT NULL,
  `productSize` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`productSizeId`),
  UNIQUE INDEX `productSizeId_UNIQUE` (`productSizeId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adhd`.`ProductOption`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`ProductOption` (
  `productOptionId` INT NOT NULL AUTO_INCREMENT,
  `productId` INT NOT NULL,
  `productOption` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`productOptionId`),
  UNIQUE INDEX `productOptionId_UNIQUE` (`productOptionId` ASC) VISIBLE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `adhd`.`ProductShoppingBasket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`ProductShoppingBasket` (
  `productShoppingBasketId` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `productId` INT NOT NULL,
  `productSize` VARCHAR(45) NULL,
  `productOption` VARCHAR(45) NULL,
  `productCnt` INT NOT NULL,
  `productDetail` VARCHAR(400) NULL,
  PRIMARY KEY (`productShoppingBasketId`),
  UNIQUE INDEX `productShoppingBasketId_UNIQUE` (`productShoppingBasketId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adhd`.`Player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`Player` (
  `playerId` INT NOT NULL AUTO_INCREMENT,
  `playerName` VARCHAR(45) NULL,
  PRIMARY KEY (`playerId`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `adhd`.`Heart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`ProductHeart` (
  `heartId` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `productId` INT NOT NULL,
  PRIMARY KEY (`heartId`))
ENGINE = InnoDB;


INSERT INTO ProductCategory
VALUES
(0, '유니폼', 1, 0),
(0, '모자', 1, 0),
(0, '의류', 1, 0),
(0, '팬상품', 1, 0),
(0, '어센틱 유니폼', 2, 1),
(0, '클러치 유니폼', 2, 1),
(0, '레플리카 유니폼', 2, 1),
(0, '유니폼 패치', 2, 1),
(0, '어센틱 모자', 2, 2),
(0, '클러치 모자', 2, 2),
(0, '패션 모자', 2, 2),
(0, '어센틱 의류', 2, 3),
(0, '클러치 의류', 2, 3),
(0, '패션 의류', 2, 3),
(0, '응원용품', 2, 4),
(0, '야구용품', 2, 4),
(0, '홈&오피스', 2, 4)
;

INSERT INTO Product
VALUES
(0, 5, '2023 어센틱 민트 유니폼', 0, 144000, 144000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/70321261-3527-41c8-8377-1ab2b48f64f520230716.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/09bae4bd-afcc-4e45-96f7-599f16326a6c20230716.jpg', false, "2023-10-11", 5),
(0, 5, '2023 어센틱 도구리 유니폼', 0, 149000, 149000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/791f7ade-bdcd-46b9-ad3b-1ca459c5f27520230515.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/492a05c0-5367-4f9f-9a95-d4b1fc5b424b20230516.jpg', false, "2023-11-11", 8),
(0, 6, '클러치 퍼즈업 유니폼', 0, 135000, 135000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/a08c1a19-9ed2-43fe-befb-a352baaf0b7420230905.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/11cc3654-46b2-44d4-89f9-45d6c6d913f520230906.jpg', false, "2023-10-10", 9),
(0, 6, '클러치 원정 유니폼', 0, 89000, 89000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/a7aa3b9b-cb69-4c6a-85f3-00c8155f547120230814.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/7cef3e4b-24e6-4a3e-928e-a534bac0fabd20230814.jpg', false, "2023-11-10", 1),
(0, 7, '레플리카 원정 유니폼', 0, 59000, 59000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/dddf465e-d272-470e-979a-5e0ab6cff92220230407.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d8546c36-34b0-4b0e-ae7b-52ca16977c0420230407.jpg', false, "2023-10-9", 2),
(0, 7, '레플리카 홈 유니폼', 0, 59000, 59000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/b9865dc0-cda0-4fd2-976a-6365a0e0f70220230407.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/0deb1328-01b6-4f5c-b7d7-4beb780173d820230407.jpg', false, "2023-11-9", 0),
(0, 8, '2023 포스트시즌 기념 열접착 패치', 0, 9000, 9000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d0f6a1ef-f5d2-4496-b325-ee14a67fa74520231015.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/42a18b84-d4d8-4ec0-96b3-3e297a0ea81d20231015.jpg', false, "2023-10-8", 0),
(0, 8, '이용찬 150세이브 기념 열접착 패치', 0, 9000, 9000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/b4ecf25b-c024-4912-b9d4-57d74d24081020230910.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/af33a5a0-3e41-43e6-af53-c32718bc497120230923.jpg', false, "2023-11-8", 6),
(0, 9, '2023 어센틱 민트 모자', 0, 42000, 42000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/f6b2e24a-effb-4120-98de-7c85842420a320230716.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d6631328-d795-4826-bbf6-58382b57faf120230717.jpg', false, "2023-10-7", 0),
(0, 9, '2023 어센틱 태극기 모자', 0, 42000, 42000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/856e921c-c074-40eb-aea1-3744c33ec24f20230716.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/3a792f88-f39b-4f16-a30d-aad8d0c4213320230717.jpg', false, "2023-11-7", 0),
(0, 10, '클러치 퍼즈업 모자', 0, 33000, 33000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d85fa992-11ba-4e2e-b5c6-8d09990d876e20230905.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/ef3f1221-2ac0-4ab8-8b33-55544a8b7c5f20230905.jpg', false, "2023-11-6", 0),
(0, 10, '클러치 민트 모자', 0, 33000, 33000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/51aa4458-09e0-4031-9c8d-29dc5cc0a77220230801.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/da33ddff-503c-4364-8116-d98cbbb9e39620230801.jpg', false, "2023-10-6", 0),
(0, 12, '2023 어센틱 동계점퍼', 0, 193500, 193500, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/29d104ae-ca94-4a67-bf32-ff2f270493a420230328.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/a8457e09-77df-47d6-af20-e202a415be9f20230327.jpg', false, "2023-11-5", 4),
(0, 12, '2023 어센틱 후드티셔츠', 0, 119000, 119000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/1113361e-04d1-46d6-8ab0-37a818e11ad620230317.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/2e9c134e-6285-4e7f-abcc-4e39418b4bb020230318.jpg', false, "2023-10-5", 3),
(0, 13, '2023 클러치 춘추점퍼', 0, 140000, 140000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/e97f660c-abc7-46c2-b12d-17f0226f2c9220230327.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/b2997767-f98b-4bc7-90d1-326a94492cb520230327.jpg', false, "2023-11-5", 2),
(0, 14, '스카이블루 단꿀 잠옷세트', 0, 49800, 49800, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d0538597-fe8d-4d2a-a19f-f8b4141372c420221020.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/03a236bb-302b-45e1-92c0-fbcf753e543520221020.jpg', false, "2023-11-4", 1),
(0, 14, '아이보리 단꿀 잠옷세트', 0, 49800, 49800, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d3a2e2fe-6648-4415-9cf4-c847f03c4fe820221024.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/13d42b24-9716-4c71-93fd-ed7e80ff7d7820221020.jpg', false, "2023-10-4", 0),
(0, 15, '민트 응원 타올', 0, 9000, 9000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/cae3ce66-42c8-4c10-8096-b516b726d29820231023.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/5439f3bb-6712-4ceb-94c6-9f0e64148c8f20231023.jpg', false, "2023-10-3", 0),
(0, 15, '민트 플라스틱 응원배트', 0, 6000, 6000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/3388bdc5-4209-46b7-9b81-a419536250ba20230625.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/eb27ae9e-d3ec-41a2-8515-1d69fca54e1a20230625.jpg', false, "2023-11-3", 0),
(0, 16, '2023 포스트시즌 기념구', 0, 15000, 15000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/8ce56aea-2360-4ea7-b37c-7a66c6db617820231015.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d4c0c971-f583-4dab-be92-aa390db92f0c20231015.jpg', false, "2023-11-2", 0),
(0, 16, '2024 드래프트 기념구', 0, 15000, 15000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/7c623185-e95a-4b5c-ae9e-febc526e91cf20231007.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/a058fedc-f24e-4819-a7a3-86ddf27292b920231007.jpg', false, "2023-10-2", 0),
(0, 17, '2023 포스트시즌 기념 아크릴 키링', 0, 7000, 7000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/3c84a33f-d01d-49a9-a6af-eabffeebc4a020231015.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/8a93a5bf-b5a3-4783-8945-7e124259365a20231015.jpg', false, "2023-10-1", 0),
(0, 17, '퍼즈업 아크릴 키링', 0, 7000, 7000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/b096259a-3ed4-43e3-9adf-e979f1abc19c20230905.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/797c9bd1-2f5f-45a0-b007-01d2cb33c10620230905.jpg', false, "2023-10-1", 0)
;

INSERT INTO productSize
VALUES
(0, 1, 'S(90)'), (0, 1, 'M(95)'), (0, 1, 'L(100)'), (0, 1, 'XL(105)'), (0, 1, '2XL(110)'), (0, 1, '4XL(120)'),
(0, 2, 'S(90)'), (0, 2, 'M(95)'), (0, 2, 'L(100)'), (0, 2, 'XL(105)'), (0, 2, '2XL(110)'), (0, 2, '4XL(120)'),
(0, 3, 'S(90)'), (0, 3, 'M(95)'), (0, 3, 'L(100)'), (0, 3, 'XL(105)'), (0, 3, '2XL(110)'), (0, 3, '4XL(120)'),
(0, 4, '5'), (0, 4, '7'), (0, 4, '9'), (0, 4, 'XS(85)'), (0, 4, 'S(90)'), (0, 4, 'M(95)'), (0, 4, 'L(100)'), (0, 4, 'XL(105)'), (0, 4, '2XL(110)'), (0, 4, '4XL(120)'),
(0, 5, '5'), (0, 5, '7'), (0, 5, '9'), (0, 5, 'S(90)'), (0, 5, 'M(95)'), (0, 5, 'L(100)'), (0, 5, 'XL(105)'), (0, 5, '2XL(110)'), (0, 5, '4XL(120)'),
(0, 6, '5'), (0, 6, '7'), (0, 6, '9'), (0, 6, 'S(90)'), (0, 6, 'M(95)'), (0, 6, 'L(100)'), (0, 6, 'XL(105)'), (0, 6, '2XL(110)'), (0, 6, '4XL(120)'),
(0, 9, '사이즈를 선택해주세요.'), (0, 9, 'XS-S'), (0, 9, 'S-M'), (0, 9, 'M-L'), (0, 9, 'L-XL'),
(0, 10, '사이즈를 선택해주세요.'), (0, 10, 'XS-S'), (0, 10, 'S-M'), (0, 10, 'M-L'), (0, 10, 'L-XL'),
(0, 11, '사이즈를 선택해주세요.'), (0, 11, 'S-M'), (0, 11, 'M-L'),
(0, 12, '사이즈를 선택해주세요.'), (0, 12, 'S-M'), (0, 12, 'M-L'),
(0, 13, 'S(90)'), (0, 13, 'M(95)'), (0, 13, 'L(100)'), (0, 13, 'XL(105)'), (0, 13, '2XL(110)'), (0, 13, '4XL(120)'),
(0, 14, 'S(90)'), (0, 14, 'M(95)'), (0, 14, 'L(100)'), (0, 14, 'XL(105)'), (0, 14, '2XL(110)'), (0, 14, '4XL(120)'),
(0, 15, '5'), (0, 15, '7'), (0, 15, '9'), (0, 15, 'XS(85)'), (0, 15, 'S(90)'), (0, 15, 'M(95)'), (0, 15, 'L(100)'), (0, 15, 'XL(105)'), (0, 15, '2XL(110)'), (0, 15, '4XL(120)'),
(0, 16, 'M(95)'), (0, 16, 'L(100)'), (0, 16, 'XL(105)'), (0, 16, '2XL(110)'), (0, 16, '4XL(120)'), (0, 16, '5-6'), (0, 16, '7-8'), (0, 16, '9-10'), (0, 16, '11-12'), (0, 16, '13-14'),
(0, 17, 'M(95)'), (0, 17, 'L(100)'), (0, 17, 'XL(105)'), (0, 17, '2XL(110)'), (0, 17, '4XL(120)'), (0, 17, '5-6'), (0, 17, '7-8'), (0, 17, '9-10'), (0, 17, '11-12'), (0, 17, '13-14')
;

INSERT INTO productOption
VALUES
(0, 1, '주장 자수 마킹(+30,000원)'), (0, 1, '자유 자수 마킹(+30,000원)'), (0, 1, '자유 열전사 마킹(+25,000원)'), (0, 1, '선수 자수 마킹(+25,000원)'), (0, 1, '선수 열전사 마킹(+20,000원)'),
(0, 2, '주장 자수 마킹(+30,000원)'), (0, 2, '자유 자수 마킹(+30,000원)'), (0, 2, '선수 자수 마킹(+25,000원)'),
(0, 3, '주장 자수 마킹(+30,000원)'), (0, 3, '자유 자수 마킹(+30,000원)'), (0, 3, '선수 자수 마킹(+25,000원)'),
(0, 4, '마킹없음'), (0, 4, '주장 자수 마킹(+30,000원)'), (0, 4, '자유 자수 마킹(+30,000원)'), (0, 4, '자유 열전사 마킹(+25,000원)'), (0, 4, '선수 자수 마킹(+25,000원)'), (0, 4, '선수 열전사 마킹(+20,000원)'),
(0, 5, '마킹없음'), (0, 5, '자유 열전사 마킹(+25,000원)'), (0, 5, '선수 열전사 마킹(+20,000원)'),
(0, 6, '마킹없음'), (0, 6, '자유 열전사 마킹(+25,000원)'), (0, 6, '선수 열전사 마킹(+20,000원)')
;

INSERT INTO ProductShoppingBasket
VALUES
(0, 'ssafy1', 2, 'S(90)', '주장 자수 마킹(+30,000원)', 1, "")
;

INSERT INTO Player
VALUES
(0, '심창민(1)'), (0, '박민우(2)'), (0, '김수윤(3)'), (0, '서호철(5)'), (0, '김철호(6)'), (0, '김주원(7)'), (0, '김재균(8)'), (0, '태너(9)'), (0, '박세혁(10)'), (0, '송명기(11)'),
(0, '정진기(12)'), (0, '페디(13)'), (0, '전루건(14)'), (0, '김태현(15)'), (0, '도태훈(16)'), (0, '김영규(17)'), (0, '박석민(18)'), (0, '신영우(19)'), (0, '최성영(20)'), (0, '김시훈(21)'),
(0, '이용찬(22)'), (0, '천재환(23)'), (0, '최우재(24)'), (0, '김성욱(25)'), (0, '박대온(26)'), (0, '박시원(28)'), (0, '이민호(29)'), (0, '임정호(30)'), (0, '손아섭(31)'), (0, '안중열(32)'),
(0, '최정원(33)'), (0, '오영수(34)'), (0, '권정웅(35)'), (0, '권희동(36)'), (0, '박건우(37)'), (0, '오장한(38)'), (0, '하준영(39)'), (0, '채지선(40)'), (0, '류진욱(41)'), (0, '서준교(42)'),
(0, '배민서(43)'), (0, '박성재(44)'), (0, '이우석(45)'), (0, '한석현(46)'), (0, '김형준(47)'), (0, '이용준(48)'), (0, '최보성(49)'), (0, '오태양(50)'), (0, '이재학(51)'), (0, '윤형준(52)'),
(0, '신민혁(53)'), (0, '김진호(54)'), (0, '마틴(55)'), (0, '정구범(56)'), (0, '전사민(57)'), (0, '서의태(58)'), (0, '구창모(59)'), (0, '한재승(60)'), (0, '배재환(61)'), (0, '하준수(62)'),
(0, '노시훈(63)'), (0, '조민석(64)'), (0, '이현우(65)'), (0, '이승현(67)'), (0, '김한별(68)'), (0, '신용석(70)'), (0, '박주찬(71)'), (0, '이주형(72)'), (0, '목지훈(73)'), (0, '전형도(74)'),
(0, '진종길(75)'), (0, '전민수(76)'), (0, '송지만(77)'), (0, '최건용(78)'), (0, '조영훈(79)'), (0, '지석훈(80)'), (0, '김건태(81)'), (0, '강인권(82)'), (0, '윤병호(83)'), (0, '손용석(84)'),
(0, '오규택(85)'), (0, '김종민(86)'), (0, '손정욱(87)'), (0, '윤수강(88)'), (0, '박석진(89)'), (0, '공필성(90)'), (0, '최시혁(91)'), (0, '박한결(92)'), (0, '이종욱(93)'), (0, '조현진(94)'),
(0, '박지한(95)'), (0, '이준호(96)'), (0, '백차승(97)'), (0, '김수경(98)'), (0, '이용훈(99)'), (0, '김범준(100)'), (0, '한재환(101)'), (0, '강건준(102)'), (0, '신성호(103)'), (0, '서동욱(105)'),
(0, '배상호(106)'), (0, '김주환(107)'), (0, '김택우(108)'), (0, '임형원(109)'), (0, '이종준(112)'), (0, '노재원(113)'), (0, '박영빈(00)')
;


select *
from ProductCategory;

select *
from Product
ORDER BY orderCnt DESC
LIMIT 10;


select *
from Product
ORDER BY regDate DESC
LIMIT 10;

SELECT p.*
FROM Product p
JOIN ProductCategory pc ON p.categoryId = pc.categoryId
WHERE (pc.parentCategoryId = 1 OR pc.categoryId = 1);






