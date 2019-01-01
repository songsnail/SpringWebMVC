USE SPRINGMVCDB;

CREATE TABLE IF NOT EXISTS book(
	b_bookId VARCHAR(10) NOT NULL,
	b_name VARCHAR(30),
	b_unitPrice  INTEGER,
	b_author VARCHAR(50),
	b_description TEXT,
	b_publisher VARCHAR(20),
	b_category VARCHAR(20),
	b_unitsInStock LONG,	
	b_releaseDate VARCHAR(20),
	b_condition VARCHAR(20),
	b_fileName  VARCHAR(20),
	PRIMARY KEY (b_bookId)
);

DELETE FROM book;
INSERT INTO book VALUES('ISBN1234', 'HTML5+CSS3',19800,'황재호', '코드와 실행 화면이 바로 보여서 눈으로만 읽어도 어떻게 작동하는지 쉽게 파악할 수 있는 것은 기본이고, 중간중간 퀴즈를 추가하여 재미있게 게임하듯 복습할 수 있습니다. 또한 이제 막 입문하여 도움을 구할 곳이 없는 여러분을 고려하여, 궁금해할 내용을 알아서 질문하고, 팁으로 친절하게 답해줍니다.','한빛미디어','IT전문서', 1000,'2018/03/02','','ISBN1234.png');
INSERT INTO book VALUES('ISBN1235', 'JSP 웹 프로그래밍', 27000, '송미영', 'JSP의 이론적 개념 → 기본 실습 → 응용 실습 순의 단계별 학습이 가능합니다. 응용 실습이 합쳐져 최종적으로 쇼핑몰 하나를 완성하는 구성이라 배운 내용이 어디에 어떻게 적용되는지 알 수 있습니다.','한빛아카데미','IT전문서',1000, '2018/10/08','', 'ISBN1235.png'); 
INSERT INTO book VALUES('ISBN1236', '워드프레스', 22000, '박현우', '이 책은 IT 초보자라도 웹에 대한 사전 지식을 익히고, 워드프레스를 설치하고, 관리자 화면에서 설정을 바꾸고, 무료 테마와 플러그인을 활용하면서 워드프레스를 배우는 전체 과정을 고스란히 담았다.', '한빛미디어듀', 'IT활용서', 1000, '2018/07/25', '','ISBN1236.png');

SELECT * FROM book;