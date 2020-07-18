select * from customer_464145;

drop table customer_464145;

create table customer_464145(custid varchar2(20) primary key, 
custname varchar2(50) not null, age number(3) not null, 
phoneno varchar2(10) not null, 
email varchar2(50)not null, 
address varchar2(200) not null);

create table customer_log_464145(custid varchar2(20) primary key,
custname varchar2(50) not null)