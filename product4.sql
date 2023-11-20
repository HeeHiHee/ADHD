-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema adhd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `adhd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `adhd` ;

-- -----------------------------------------------------
-- Table `adhd`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`user` (
  `userId` VARCHAR(45) NOT NULL,
  `userPw` VARCHAR(45) NOT NULL,
  `userName` VARCHAR(10) NOT NULL,
  `userPhone` VARCHAR(45) NOT NULL,
  `userEmail` VARCHAR(100) NOT NULL,
  `userNickname` VARCHAR(45) NOT NULL,
  `manager` TINYINT NOT NULL,
  `userStatus` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adhd`.`deliveryaddress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`deliveryaddress` (
  `deliveryAddressId` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `deliveryName` VARCHAR(45) NOT NULL,
  `receiverName` VARCHAR(45) NOT NULL,
  `receiverPhone` VARCHAR(45) NOT NULL,
  `additionalPhone` VARCHAR(45) NULL DEFAULT NULL,
  `deliveryAddress1` VARCHAR(45) NOT NULL,
  `deliveryAddress2` VARCHAR(45) NOT NULL,
  `deliveryMemo` VARCHAR(100) NULL,
  `defaultAddress` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`deliveryAddressId`),
  UNIQUE INDEX `deliveryAddressId_UNIQUE` (`deliveryAddressId` ASC) VISIBLE,
  INDEX `fk_deliveryAddress_User1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_deliveryAddress_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `adhd`.`user` (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adhd`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`player` (
  `playerId` INT NOT NULL AUTO_INCREMENT,
  `playerName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`playerId`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adhd`.`productcategory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`productcategory` (
  `categoryId` INT NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(45) NOT NULL,
  `level` INT NOT NULL,
  `parentCategoryId` INT NOT NULL,
  PRIMARY KEY (`categoryId`),
  UNIQUE INDEX `categoryId_UNIQUE` (`categoryId` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adhd`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`product` (
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
  `productDelete` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`productId`),
  UNIQUE INDEX `productId_UNIQUE` (`productId` ASC) VISIBLE,
  INDEX `fk_product_productcategory_idx` (`categoryId` ASC) VISIBLE,
  CONSTRAINT `fk_product_productcategory`
    FOREIGN KEY (`categoryId`)
    REFERENCES `adhd`.`productcategory` (`categoryId`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adhd`.`productheart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`productheart` (
  `heartId` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `productId` INT NOT NULL,
  PRIMARY KEY (`heartId`),
  INDEX `fk_productheart_product1_idx` (`productId` ASC) VISIBLE,
  INDEX `fk_productheart_User1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_productheart_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `adhd`.`product` (`productId`),
  CONSTRAINT `fk_productheart_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `adhd`.`user` (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adhd`.`productoption`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`productoption` (
  `productOptionId` INT NOT NULL AUTO_INCREMENT,
  `productId` INT NOT NULL,
  `productOption` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`productOptionId`),
  UNIQUE INDEX `productOptionId_UNIQUE` (`productOptionId` ASC) VISIBLE,
  INDEX `fk_productoption_product1_idx` (`productId` ASC) VISIBLE,
  CONSTRAINT `fk_productoption_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `adhd`.`product` (`productId`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adhd`.`productshoppingbasket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`productshoppingbasket` (
  `productShoppingBasketId` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `productId` INT NOT NULL,
  `productSize` VARCHAR(45) NULL DEFAULT NULL,
  `productOption` VARCHAR(45) NULL DEFAULT NULL,
  `productCnt` INT NOT NULL,
  `productDetail` VARCHAR(400) NULL DEFAULT NULL,
  PRIMARY KEY (`productShoppingBasketId`),
  UNIQUE INDEX `productShoppingBasketId_UNIQUE` (`productShoppingBasketId` ASC) VISIBLE,
  INDEX `fk_productshoppingbasket_product1_idx` (`productId` ASC) VISIBLE,
  INDEX `fk_productshoppingbasket_User1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_productshoppingbasket_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `adhd`.`product` (`productId`),
  CONSTRAINT `fk_productshoppingbasket_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `adhd`.`user` (`userId`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adhd`.`productsize`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`productsize` (
  `productSizeId` INT NOT NULL AUTO_INCREMENT,
  `productId` INT NOT NULL,
  `productSize` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`productSizeId`),
  UNIQUE INDEX `productSizeId_UNIQUE` (`productSizeId` ASC) VISIBLE,
  INDEX `fk_productsize_product1_idx` (`productId` ASC) VISIBLE,
  CONSTRAINT `fk_productsize_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `adhd`.`product` (`productId`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adhd`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`order` (
  `orderId` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `totalPrice` INT NOT NULL,
  `orderDate` TIMESTAMP NULL DEFAULT NOW(),
  `card` VARCHAR(45) NULL,
  `refundReason` VARCHAR(300) NULL,
  `receiverName` VARCHAR(45) NOT NULL,
  `deliveryAddress1` VARCHAR(45) NOT NULL,
  `deliveryAddress2` VARCHAR(45) NOT NULL,
  `receiverPhone` VARCHAR(45) NOT NULL,
  `deliveryMemo` VARCHAR(100) NULL,
  PRIMARY KEY (`orderId`),
  UNIQUE INDEX `orderId_UNIQUE` (`orderId` ASC) VISIBLE,
  INDEX `fk_order_user1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`userId`)
    REFERENCES `adhd`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adhd`.`orderDetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`orderDetail` (
  `orderDetailId` INT NOT NULL AUTO_INCREMENT,
  `orderId` INT NOT NULL,
  `productId` INT NOT NULL,
  `price` INT NULL,
  `cnt` INT NOT NULL,
  PRIMARY KEY (`orderDetailId`),
  UNIQUE INDEX `orderDetailId_UNIQUE` (`orderDetailId` ASC) VISIBLE,
  INDEX `fk_orderDetail_order1_idx` (`orderId` ASC) VISIBLE,
  INDEX `fk_orderDetail_product1_idx` (`productId` ASC) VISIBLE,
  CONSTRAINT `fk_orderDetail_order1`
    FOREIGN KEY (`orderId`)
    REFERENCES `adhd`.`order` (`orderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderDetail_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `adhd`.`product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adhd`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`review` (
  `reviewId` INT NOT NULL AUTO_INCREMENT,
  `productId` INT NOT NULL,
  `userId` VARCHAR(45) NOT NULL,
  `type` VARCHAR(1) NOT NULL,
  `reviewTitle` VARCHAR(45) NOT NULL,
  `reviewDate` TIMESTAMP NULL,
  `reviewContent` VARCHAR(400) NOT NULL,
  `reviewStar` INT NULL,
  `reviewDelete` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`reviewId`),
  INDEX `fk_review_product1_idx` (`productId` ASC) VISIBLE,
  INDEX `fk_review_user1_idx` (`userId` ASC) VISIBLE,
  UNIQUE INDEX `reviewId_UNIQUE` (`reviewId` ASC) VISIBLE,
  CONSTRAINT `fk_review_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `adhd`.`product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_user1`
    FOREIGN KEY (`userId`)
    REFERENCES `adhd`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adhd`.`manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`manager` (
  `managerId` VARCHAR(45) NOT NULL,
  `managerPw` VARCHAR(45) NOT NULL,
  `managerName` VARCHAR(45) NOT NULL,
  `managerDelete` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`managerId`),
  UNIQUE INDEX `managerId_UNIQUE` (`managerId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adhd`.`managernotice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`managernotice` (
  `noticeId` INT NOT NULL AUTO_INCREMENT,
  `managerId` VARCHAR(45) NOT NULL,
  `noticeType` VARCHAR(45) NOT NULL,
  `noticeTitle` VARCHAR(45) NOT NULL,
  `noticeContent` VARCHAR(400) NOT NULL,
  `noticeWriter` VARCHAR(45) NOT NULL,
  `noticeImg` VARCHAR(400) NULL,
  `noticeViews` INT NOT NULL,
  `noticeDate` TIMESTAMP NOT NULL,
  `noticeDelete` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`noticeId`),
  UNIQUE INDEX `noticeId_UNIQUE` (`noticeId` ASC) VISIBLE,
  INDEX `fk_notice_manager1_idx` (`managerId` ASC) VISIBLE,
  CONSTRAINT `fk_notice_manager1`
    FOREIGN KEY (`managerId`)
    REFERENCES `adhd`.`manager` (`managerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adhd`.`managercomment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`managercomment` (
  `commentId` INT NOT NULL AUTO_INCREMENT,
  `managerId` VARCHAR(45) NOT NULL,
  `reviewId` INT NOT NULL,
  `commentContent` VARCHAR(400) NOT NULL,
  `commentDate` TIMESTAMP NOT NULL,
  `commentDelete` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`commentId`),
  UNIQUE INDEX `commentId_UNIQUE` (`commentId` ASC) VISIBLE,
  INDEX `fk_managercomment_manager1_idx` (`managerId` ASC) VISIBLE,
  INDEX `fk_managercomment_review1_idx` (`reviewId` ASC) VISIBLE,
  CONSTRAINT `fk_managercomment_manager1`
    FOREIGN KEY (`managerId`)
    REFERENCES `adhd`.`manager` (`managerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_managercomment_review1`
    FOREIGN KEY (`reviewId`)
    REFERENCES `adhd`.`review` (`reviewId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


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
(0, 5, '2023 어센틱 민트 유니폼', 0, 144000, 144000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/70321261-3527-41c8-8377-1ab2b48f64f520230716.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/09bae4bd-afcc-4e45-96f7-599f16326a6c20230716.jpg', false, "2023-10-11", 5, 'N'),
(0, 5, '2023 어센틱 도구리 유니폼', 0, 149000, 149000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/791f7ade-bdcd-46b9-ad3b-1ca459c5f27520230515.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/492a05c0-5367-4f9f-9a95-d4b1fc5b424b20230516.jpg', false, "2023-11-11", 8, 'N'),
(0, 6, '클러치 퍼즈업 유니폼', 0, 135000, 135000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/a08c1a19-9ed2-43fe-befb-a352baaf0b7420230905.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/11cc3654-46b2-44d4-89f9-45d6c6d913f520230906.jpg', false, "2023-10-10", 9, 'N'),
(0, 6, '클러치 원정 유니폼', 0, 89000, 89000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/a7aa3b9b-cb69-4c6a-85f3-00c8155f547120230814.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/7cef3e4b-24e6-4a3e-928e-a534bac0fabd20230814.jpg', false, "2023-11-10", 1, 'N'),
(0, 7, '레플리카 원정 유니폼', 0, 59000, 59000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/dddf465e-d272-470e-979a-5e0ab6cff92220230407.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d8546c36-34b0-4b0e-ae7b-52ca16977c0420230407.jpg', false, "2023-10-9", 2, 'N'),
(0, 7, '레플리카 홈 유니폼', 0, 59000, 59000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/b9865dc0-cda0-4fd2-976a-6365a0e0f70220230407.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/0deb1328-01b6-4f5c-b7d7-4beb780173d820230407.jpg', false, "2023-11-9", 0, 'N'),
(0, 8, '2023 포스트시즌 기념 열접착 패치', 0, 9000, 9000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d0f6a1ef-f5d2-4496-b325-ee14a67fa74520231015.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/42a18b84-d4d8-4ec0-96b3-3e297a0ea81d20231015.jpg', false, "2023-10-8", 0, 'N'),
(0, 8, '이용찬 150세이브 기념 열접착 패치', 0, 9000, 9000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/b4ecf25b-c024-4912-b9d4-57d74d24081020230910.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/af33a5a0-3e41-43e6-af53-c32718bc497120230923.jpg', false, "2023-11-8", 6, 'N'),
(0, 9, '2023 어센틱 민트 모자', 0, 42000, 42000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/f6b2e24a-effb-4120-98de-7c85842420a320230716.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d6631328-d795-4826-bbf6-58382b57faf120230717.jpg', false, "2023-10-7", 0, 'N'),
(0, 9, '2023 어센틱 태극기 모자', 0, 42000, 42000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/856e921c-c074-40eb-aea1-3744c33ec24f20230716.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/3a792f88-f39b-4f16-a30d-aad8d0c4213320230717.jpg', false, "2023-11-7", 0, 'N'),
(0, 10, '클러치 퍼즈업 모자', 0, 33000, 33000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d85fa992-11ba-4e2e-b5c6-8d09990d876e20230905.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/ef3f1221-2ac0-4ab8-8b33-55544a8b7c5f20230905.jpg', false, "2023-11-6", 0, 'N'),
(0, 10, '클러치 민트 모자', 0, 33000, 33000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/51aa4458-09e0-4031-9c8d-29dc5cc0a77220230801.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/da33ddff-503c-4364-8116-d98cbbb9e39620230801.jpg', false, "2023-10-6", 0, 'N'),
(0, 12, '2023 어센틱 동계점퍼', 0, 193500, 193500, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/29d104ae-ca94-4a67-bf32-ff2f270493a420230328.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/a8457e09-77df-47d6-af20-e202a415be9f20230327.jpg', false, "2023-11-5", 4, 'N'),
(0, 12, '2023 어센틱 후드티셔츠', 0, 119000, 119000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/1113361e-04d1-46d6-8ab0-37a818e11ad620230317.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/2e9c134e-6285-4e7f-abcc-4e39418b4bb020230318.jpg', false, "2023-10-5", 3, 'N'),
(0, 13, '2023 클러치 춘추점퍼', 0, 140000, 140000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/e97f660c-abc7-46c2-b12d-17f0226f2c9220230327.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/b2997767-f98b-4bc7-90d1-326a94492cb520230327.jpg', false, "2023-11-5", 2, 'N'),
(0, 14, '스카이블루 단꿀 잠옷세트', 0, 49800, 49800, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d0538597-fe8d-4d2a-a19f-f8b4141372c420221020.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/03a236bb-302b-45e1-92c0-fbcf753e543520221020.jpg', false, "2023-11-4", 1, 'N'),
(0, 14, '아이보리 단꿀 잠옷세트', 0, 49800, 49800, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d3a2e2fe-6648-4415-9cf4-c847f03c4fe820221024.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/13d42b24-9716-4c71-93fd-ed7e80ff7d7820221020.jpg', false, "2023-10-4", 0, 'N'),
(0, 15, '민트 응원 타올', 0, 9000, 9000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/cae3ce66-42c8-4c10-8096-b516b726d29820231023.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/5439f3bb-6712-4ceb-94c6-9f0e64148c8f20231023.jpg', false, "2023-10-3", 0, 'N'),
(0, 15, '민트 플라스틱 응원배트', 0, 6000, 6000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/3388bdc5-4209-46b7-9b81-a419536250ba20230625.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/eb27ae9e-d3ec-41a2-8515-1d69fca54e1a20230625.jpg', false, "2023-11-3", 0, 'N'),
(0, 16, '2023 포스트시즌 기념구', 0, 15000, 15000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/8ce56aea-2360-4ea7-b37c-7a66c6db617820231015.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/d4c0c971-f583-4dab-be92-aa390db92f0c20231015.jpg', false, "2023-11-2", 0, 'N'),
(0, 16, '2024 드래프트 기념구', 0, 15000, 15000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/7c623185-e95a-4b5c-ae9e-febc526e91cf20231007.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/a058fedc-f24e-4819-a7a3-86ddf27292b920231007.jpg', false, "2023-10-2", 0, 'N'),
(0, 17, '2023 포스트시즌 기념 아크릴 키링', 0, 7000, 7000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/3c84a33f-d01d-49a9-a6af-eabffeebc4a020231015.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/8a93a5bf-b5a3-4783-8945-7e124259365a20231015.jpg', false, "2023-10-1", 0, 'N'),
(0, 17, '퍼즈업 아크릴 키링', 0, 7000, 7000, 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/b096259a-3ed4-43e3-9adf-e979f1abc19c20230905.jpg', 'https://d29trs2nbedcfj.cloudfront.net/erp/shop/797c9bd1-2f5f-45a0-b007-01d2cb33c10620230905.jpg', false, "2023-10-1", 0, 'N')
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

INSERT INTO User
VALUES
('ssafy1', '1234', '최싸피', '01012345678', 'ssafy1@ssafy.com', '췍췍', true, 'Y'),
('ssafy2', '5678', '이싸피', '01056781234', 'ssafy2@ssafy.com', '잉잉', false, 'Y')
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
(0, 'ssafy1', 2, 'S(90)', '주장 자수 마킹(+30,000원)', 1, '')
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

INSERT INTO deliveryaddress
VALUES
(0, 'ssafy1', '짱구네', '짱구', '01077778888', '', '일본', '짱구집', '안전하게 와주세요', 'Y'),
(0, 'ssafy2', '철수네', '철수', '01055554444', '', '일본', '철수집', '', 'N')
;

INSERT INTO manager
VALUES
('jjanggu', '1111', '짱구', 'N'),
('chulsu', '2222', '철수', 'N')
;

INSERT INTO review
VALUES
(0, 17, 'ssafy1', 'R', '상품 너무 이뽀요', '2023-11-20', '어제 택배 받았는데 너무 맘에 들어요', 5, 'N'),
(0, 23, 'ssafy2', 'Q', '환불 문의', '2023-11-20', '이거 환불 어케해여', NULL, 'N')
;

INSERT INTO managercomment
VALUES
(0, 'jjanggu', 1, '상품이 맘에 드시다니 다행이네여', '2023-11-20', 'N'),
(0, 'chulsu', 2, '환불 안내해드리겠습니다', '2023-11-20', 'N')
;

SELECT *
FROM review;

SELECT *
FROM managercomment;


