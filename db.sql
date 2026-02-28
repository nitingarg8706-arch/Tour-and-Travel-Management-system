create database tts;
show databases;
use tts ; 
create table account(username varchar(20), name varchar(20), password varchar(20), security varchar(20), answer varchar(20));
show tables;
select * from account;
create table customer(username varchar(20), id varchar(30), number varchar(15), name varchar(30), gender varchar(20), country varchar(30), address varchar(50), phone varchar(15), email varchar(30));
select * from customer;
create table bookpackage(username varchar(20), package varchar(30), person varchar(20), id varchar(30), number varchar(30), phone varchar(20), price varchar(20));
select * from bookpackage;
create table hotel(name varchar(20), costperperson varchar(20), acroom varchar(10), foodinclude varchar(20));
insert into hotel values('The Bay Club Hotel','5000','2000','1500');
insert into hotel values(' Four Seasons Hotel','4000','1500','2000');
insert into hotel values('Breeze Blow Hotel','4500','1600','1500');
insert into hotel values('The Taj Hotel','6000','2000','1600');
-- insert into hotel values('Happy Morning Hotel','5000','2000','1550');
-- insert into hotel values('Piyamit Hotel','3000','2000','1200');
-- insert into hotel values('Worada Ressort','4500','2000','1700');
-- insert into hotel values('A9 Hotel','3500','2000','1350');
-- insert into hotel values('Raddison Blue Hotel','5500','2000','1800');
-- insert into hotel values('Classio Hotel','5700','2000','1900') ;
select * from hotel;
drop table hotel;
create table bookhotel(username varchar(20), name varchar(20), person varchar(20), days varchar(20), ac varchar(20), food varchar(20), id varchar(20), number varchar(20), phone varchar(20), price varchar(20));
select * from bookhotel;


