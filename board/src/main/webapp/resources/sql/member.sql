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

INSERT INTO member VALUES('Admin', 'Admin123', '������', '��', '010-1000-1000', '����� ���α�', 'ROLE_ADMIN');
INSERT INTO member VALUES('guest', 'guest', 'ȫ���', '��', '010-9002-1004', '����� ���α�', 'ROLE_USER');
INSERT INTO member VALUES('songmy', 'songmy', '�۹̿�', '��', '011-9002-7370', '��õ�� ������', 'ROLE_USER');

drop table member;