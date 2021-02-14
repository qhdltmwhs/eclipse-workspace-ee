drop table student;
create table student (
		no number(4) primary key,
		name varchar2(20),
		kor number(3),
		eng number(3),
		math number(3),
		tot number(3),
		avg number(5,2),
		grade char(1),
        rank number(3)
);