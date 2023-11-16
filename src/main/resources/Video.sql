
USE ssafit;

CREATE TABLE IF NOT EXISTS `video`(
	`id` varchar(40) CHARACTER SET utf8mb4 NOT NULL PRIMARY KEY,
    `title` varchar(100) CHARACTER SET utf8mb4 NOT NULL,
    `fitPartName` varchar(10) CHARACTER SET utf8mb4 NOT NULL,
    `channel_name` varchar(20) CHARACTER SET utf8mb4 NOT NULL,
    `url`	varchar(200) CHARACTER SET utf8mb4 NOT NULL,
    `viewCnt`	int(5) DEFAULT 0
)ENGINE=innoDB;

CREATE TABLE IF NOT EXISTS `user`(
	`id` varchar(40) CHARACTER SET utf8mb4 NOT NULL PRIMARY KEY,
    `name`  varchar(20) CHARACTER SET utf8mb4 NOT NULL,
    `email`  varchar(80) CHARACTER SET utf8mb4 NOT NULL UNIQUE,
    `pw`  varchar(40) CHARACTER SET utf8mb4 NOT NULL
)ENGINE=innoDB;

CREATE TABLE IF NOT EXISTS `review`(
	`videoid` varchar(40) CHARACTER SET utf8mb4 NOT NULL,
    `reviewid` int(10) AUTO_INCREMENT PRIMARY KEY,
    `title`	varchar(40) CHARACTER SET utf8mb4 NOT NULL,
    `writer`varchar(40) CHARACTER SET utf8mb4 NOT NULL,
    `content` text CHARACTER SET utf8mb4,
    `regdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `viewCnt` int(10) DEFAULT 0,
    CONSTRAINT `review_ibfk_1` FOREIGN KEY (`videoid`) REFERENCES `video`(`id`)
)ENGINE=innoDB;

INSERT INTO video (id, title, fitPartName, channel_name, url) 
VALUES
('gMaB-fG4u4g','전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]','전신','ThankyouBUBU','https://www.youtube.com/embed/gMaB-fG4u4g'),
('swRNeYw1JkY','하루 15분! 전신 칼로리 불태우는 다이어트 운동','전신','ThankyouBUBU','https://www.youtube.com/embed/swRNeYw1JkY'),
('54tTYO-vU2E','상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]','상체','ThankyouBUBU','https://www.youtube.com/embed/54tTYO-vU2E'),
('QqqZH3j_vH0','상체비만 다이어트 최고의 운동 [상체 핵매운맛]','상체','ThankyouBUBU','https://www.youtube.com/embed/QqqZH3j_vH0'),
('tzN6ypk6Sps','하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]','하체','김강민','https://www.youtube.com/embed/tzN6ypk6Sps'),
('u5OgcZdNbMo','저는 하체 식주의자 입니다','하체','GYM종국','https://www.youtube.com/embed/u5OgcZdNbMo'),
('PjGcOP-TQPE','11자복근 복부 최고의 운동 [복근 핵매운맛]','복부','ThankyouBUBU','https://www.youtube.com/embed/PjGcOP-TQPE'),
('7TLk7pscICk','(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)','복부','SomiFit','https://www.youtube.com/embed/7TLk7pscICk');


INSERT INTO user (id, name, email, pw)
VALUES
('ssafy','강준규','ssafy@ssafy.com','1234'),
('ssafy2','최다희','ssafy2@ssafy.com','1234')
;

INSERT INTO review (videoid, title, writer, content)
VALUES
('54tTYO-vU2E','테스트 제목','테스트 작성자','테스트 콘텐츠');

select * from user;
select * from review;

		SELECT *
		FROM review
		WHERE reviewid = 1;
        
SELECT * FROM video;

SELECT * FROM video WHERE fitPartName LIKE CONCAT('%', "하체", '%');

		select  *
		from user;

		select *
		from user
		WHERE id LIKE CONCAT ('%', "2" '%');