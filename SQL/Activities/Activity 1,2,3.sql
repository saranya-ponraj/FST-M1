REM   Script: Activity 1,2,3
REM   Activity 1,2,3

create table t(a char(10),b varchar(10),c varchar(10) );

insert into t(a,b,c) values('rahul','saranya','ponraj');

CREATE TABLE salesman (sales_id int primary key,salesman_name varchar(20),salesman_city varchar(20),commision int);

DESCRIBE salesman


INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

select * from salesman;

SELECT salesman_id, salesman_city FROM salesman;

SELECT sales_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT sales_id, commission FROM salesman WHERE salesman_name='Paul Adam';

SELECT sales_id, commision FROM salesman WHERE salesman_name='Paul Adam';

