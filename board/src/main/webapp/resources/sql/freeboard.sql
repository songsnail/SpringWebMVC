USE SPRINGMVCDB;

CREATE TABLE IF NOT EXISTS  freeboard (
       num int not null auto_increment,
       name varchar(20) not null,
       passwd varchar(20) not null,
       subject varchar(100) not null,
       content text not null,
       regist_day varchar(30),
       hit int,
       ip varchar(20),
       PRIMARY KEY (num)
)default CHARSET=utf8;



