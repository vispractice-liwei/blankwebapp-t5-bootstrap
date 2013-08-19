drop table sm_user if exists
drop table sm_code if exists

-- Tables
create table sm_code (id bigint generated by default as identity (start with 1), version int, code varchar(255), value varchar(255), remark varchar(255), primary key (id))
create table sm_user (id bigint generated by default as identity (start with 1), version int, LOGIN_NAME varchar(255), password varchar(255), primary key (id))

-- Data
insert into sm_code (code,value,remark) values ('c1','v1','r1')
insert into sm_user (LOGIN_NAME,password) values ('l1', 'Bernard-Dupont')
insert into sm_user (LOGIN_NAME,password) values ('l2', 'time')
insert into sm_user (LOGIN_NAME,password) values ('l3', 'password')
insert into sm_user (LOGIN_NAME,password) values ('l4', '12')
insert into sm_user (LOGIN_NAME,password) values ('l5', '1')
insert into sm_user (LOGIN_NAME,password) values ('l6', '123456')
insert into sm_user (LOGIN_NAME,password) values ('l7', '111111')
insert into sm_user (LOGIN_NAME,password) values ('l8', '11111111')
insert into sm_user (LOGIN_NAME,password) values ('l9', 'welcome')
insert into sm_user (LOGIN_NAME,password) values ('l0', '911')
insert into sm_user (LOGIN_NAME,password) values ('n1', 'hello')
insert into sm_user (LOGIN_NAME,password) values ('n2', 'kick')
insert into sm_user (LOGIN_NAME,password) values ('n3', 'Bernard')
insert into sm_user (LOGIN_NAME,password) values ('n4', 'Dupont')
insert into sm_user (LOGIN_NAME,password) values ('n5', 'do')
insert into sm_user (LOGIN_NAME,password) values ('n6', 'no')
insert into sm_user (LOGIN_NAME,password) values ('n7', 'yes')
insert into sm_user (LOGIN_NAME,password) values ('n9', 'ena9')
insert into sm_user (LOGIN_NAME,password) values ('n0', 'ena0')
insert into sm_user (LOGIN_NAME,password) values ('m1', 'ena8')
insert into sm_user (LOGIN_NAME,password) values ('m2', 'ena7')
insert into sm_user (LOGIN_NAME,password) values ('m3', 'ena6')
insert into sm_user (LOGIN_NAME,password) values ('m4', 'ena5')
insert into sm_user (LOGIN_NAME,password) values ('nmn8', 'ena4')
insert into sm_user (LOGIN_NAME,password) values ('m5', 'ena3')
insert into sm_user (LOGIN_NAME,password) values ('m6', 'ena2')
insert into sm_user (LOGIN_NAME,password) values ('m7', 'ena1')


