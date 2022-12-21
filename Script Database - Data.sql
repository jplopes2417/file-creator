CREATE DATABASE SALES;

USE SALES;

CREATE TABLE local_type (
local_id int AUTO_INCREMENT NOT NULL,
local_description varchar(255) NOT NULL,
CONSTRAINT PK_LOCAL_TYPE PRIMARY KEY (local_id)
);

CREATE TABLE sales_details (
sale_id int AUTO_INCREMENT NOT NULL,
username varchar(255) NOT NULL,
transaction_date DATETIME NOT NULL,
transaction_value decimal(15,2) NOT NULL,
transaction_description varchar(100) NOT NULL,
transaction_type varchar(1) NOT NULL,
local_type int NOT NULL,
CONSTRAINT PK_SALES PRIMARY KEY (sale_id),
FOREIGN KEY (local_type) REFERENCES local_type(local_id)
);

CREATE PROCEDURE generateDebitData()
BEGIN
	DECLARE i int DEFAULT 1;
	WHILE i <= 5000 DO
	INSERT INTO 
	sales_details
VALUES (null,
lpad(conv(floor(rand()* pow(36, 6)), 10, 36), 20, 'SALES-NAME:'),
DATE_FORMAT(SYSDATE(), '%Y-%m-%d %k:%i:%s' ),
FORMAT(RAND()*(100-5)+ 5, 2),
'NEW SALE',
'D',
(
SELECT
	local_id
FROM
	local_type lt
WHERE
	lt.local_description = 'GAS STATION')
);

SET i = i + 1;
select CONCAT('ACTUAL LOOP POSITION: ', i);

END WHILE;

END;

CREATE PROCEDURE generateCreditData()
BEGIN
	DECLARE i int DEFAULT 1;
	WHILE i <= 5000 DO
	INSERT INTO 
	sales_details
VALUES (null,
lpad(conv(floor(rand()* pow(36, 6)), 10, 36), 20, 'SALES-NAME:'),
DATE_FORMAT(SYSDATE(), '%Y-%m-%d %k:%i:%s' ),
FORMAT(RAND()*(100-5)+ 5, 2),
'NEW SALE',
'C',
(
SELECT
	local_id
FROM
	local_type lt
WHERE
	lt.local_description = 'E-COMMERCE')
);

SET i = i + 1;
select CONCAT('ACTUAL LOOP POSITION: ', i);

END WHILE;

END;

call generateDebitData();
call generateCreditData();