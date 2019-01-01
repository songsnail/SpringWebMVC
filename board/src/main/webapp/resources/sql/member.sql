USE SPRINGMVCDB;

CREATE TABLE IF NOT EXISTS member ( 
    id varchar(10) not null,
    passwd varchar(10) not null,
    name varchar(10) not null,
    sex varchar(4),
    tel varchar(20),
    address varchar(90),   
    role varchar(30),
    primary key(id) 
) default CHARSET=utf8;

INSERT INTO member VALUES('Admin', 'Admin123', '관리자', '여', '010-1000-1000', '서울시 구로구', 'ROLE_ADMIN');
INSERT INTO member VALUES('guest', 'guest', '홍길순', '여', '010-9002-1004', '서울시 구로구', 'ROLE_USER');
INSERT INTO member VALUES('songmy', 'songmy', '송미영', '여', '011-9002-7370', '인천시 남동구', 'ROLE_USER');

drop table member;