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
-- Table `adhd`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`player` (
  `playerId` INT NOT NULL AUTO_INCREMENT,
  `playerName` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`playerId`))
ENGINE = InnoDB
AUTO_INCREMENT = 108
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
AUTO_INCREMENT = 18
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
  PRIMARY KEY (`productId`),
  UNIQUE INDEX `productId_UNIQUE` (`productId` ASC) VISIBLE,
  INDEX `fk_product_productcategory_idx` (`categoryId` ASC) VISIBLE,
  CONSTRAINT `fk_product_productcategory`
    FOREIGN KEY (`categoryId`)
    REFERENCES `adhd`.`productcategory` (`categoryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adhd`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`User` (
  `userId` VARCHAR(45) NOT NULL,
  `userPw` VARCHAR(45) NOT NULL,
  `userName` VARCHAR(10) NOT NULL,
  `userPhone` VARCHAR(45) NOT NULL,
  `userEmail` VARCHAR(100) NOT NULL,
  `userNickname` VARCHAR(45) NOT NULL,
  `manager` TINYINT NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC) VISIBLE)
ENGINE = InnoDB;


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
    REFERENCES `adhd`.`product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productheart_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `adhd`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
    REFERENCES `adhd`.`product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 24
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
    REFERENCES `adhd`.`product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productshoppingbasket_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `adhd`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
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
    REFERENCES `adhd`.`product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 105
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adhd`.`deliveryAddress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adhd`.`deliveryAddress` (
  `deliveryAddressId` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `deliveryName` VARCHAR(45) NOT NULL,
  `receiverName` VARCHAR(45) NOT NULL,
  `receiverPhone` VARCHAR(45) NOT NULL,
  `additionalPhone` VARCHAR(45) NULL,
  `deliveryAddress1` VARCHAR(45) NOT NULL,
  `deliveryAddress2` VARCHAR(45) NOT NULL,
  `deliveryMemo` VARCHAR(100) NULL,
  PRIMARY KEY (`deliveryAddressId`),
  UNIQUE INDEX `deliveryAddressId_UNIQUE` (`deliveryAddressId` ASC) VISIBLE,
  INDEX `fk_deliveryAddress_User1_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_deliveryAddress_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `adhd`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO User
VALUES
('ssafy1', '1234', '최싸피', '01012345678', 'ssafy1@ssafy.com', '췍췍', true),
('ssafy2', '5678', '이싸피', '01056781234', 'ssafy2@ssafy.com', '잉잉', false)
;

SELECT * 
FROM User;
