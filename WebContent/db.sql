CREATE TABLE user_tbl(
ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
Name VARCHAR(50) NOT NULL,
Address VARCHAR(50) NOT NULL,
Password VARCHAR(50) NOT NULL
);

CREATE TABLE start_tbl(
	ID INT NOT NULL,
	Start INT,
	Goal INT
);

CREATE TABLE fixedbudget_tbl(
	ID INT NOT NULL,
	Type VARCHAR(50),
	Money INT,
	Day INT
);

CREATE TABLE wantlist_tbl(
	ID INT NOT NULL,
	Categoly VARCHAR(50),
	TradeName VARCHAR(50),
	Amount INT,
	Priority INT
);

CREATE TABLE pay_tbl(
	ID INT NOT NULL,
	itemname VARCHAR(50),
	Day INT,
	Money INT
);

SELECT * FROM user_tbl
DROP table user_tbl

SELECT * FROM start_tbl
DROP TABLE start_tbl

SELECT * FROM fixedbudget_tbl
DROP TABLE fixedbudget_tbl

SELECT * FROM wantlist_tbl
DROP table wantlist_tbl

SELECT * FROM pay_tbl
DROP table pay_tbl

INSERT INTO USER_TBL (name,address,password) values ('student','george@gmail.com','sanriko')
INSERT INTO FixedBudget_tbl (ID,TYPE,MONEY,DAY) VALUES (1,'光熱費',6000,120)

SELECT * FROM USER_TBL WHERE ADDRESS = 'jack@gmail.com' AND PASSWORD = '0000'
SELECT ID FROM USER_TBL WHERE ADDRESS = 'george@gmail.com' AND PASSWORD = 'sanriko'