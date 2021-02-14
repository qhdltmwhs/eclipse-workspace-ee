drop table address;
create table address (
		no number(4) primary key,
		id varchar2(20),
		name varchar2(20),
		phone varchar2(15),
		address varchar2(60)
);
drop sequence address_no_seq;
create sequence address_no_seq
start with 1 nocycle nocache;

desc address;








