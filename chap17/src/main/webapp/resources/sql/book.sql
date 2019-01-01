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
INSERT INTO book VALUES('ISBN1234', 'HTML5+CSS3',19800,'Ȳ��ȣ', '�ڵ�� ���� ȭ���� �ٷ� ������ �����θ� �о ��� �۵��ϴ��� ���� �ľ��� �� �ִ� ���� �⺻�̰�, �߰��߰� ��� �߰��Ͽ� ����ְ� �����ϵ� ������ �� �ֽ��ϴ�. ���� ���� �� �Թ��Ͽ� ������ ���� ���� ���� �������� ����Ͽ�, �ñ����� ������ �˾Ƽ� �����ϰ�, ������ ģ���ϰ� �����ݴϴ�.','�Ѻ��̵��','IT������', 1000,'2018/03/02','','ISBN1234.png');
INSERT INTO book VALUES('ISBN1235', 'JSP �� ���α׷���', 27000, '�۹̿�', 'JSP�� �̷��� ���� �� �⺻ �ǽ� �� ���� �ǽ� ���� �ܰ躰 �н��� �����մϴ�. ���� �ǽ��� ������ ���������� ���θ� �ϳ��� �ϼ��ϴ� �����̶� ��� ������ ��� ��� ����Ǵ��� �� �� �ֽ��ϴ�.','�Ѻ���ī����','IT������',1000, '2018/10/08','', 'ISBN1235.png'); 
INSERT INTO book VALUES('ISBN1236', '����������', 22000, '������', '�� å�� IT �ʺ��ڶ� ���� ���� ���� ������ ������, ������������ ��ġ�ϰ�, ������ ȭ�鿡�� ������ �ٲٰ�, ���� �׸��� �÷������� Ȱ���ϸ鼭 ������������ ���� ��ü ������ ������ ��Ҵ�.', '�Ѻ��̵���', 'ITȰ�뼭', 1000, '2018/07/25', '','ISBN1236.png');

SELECT * FROM book;