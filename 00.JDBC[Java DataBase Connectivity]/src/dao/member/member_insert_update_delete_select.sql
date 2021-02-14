--insert
INSERT INTO member (m_id, m_password, m_name, m_address, m_age, m_married, m_regdate) 
	VALUES ('guard','1111','김경호','서울시 관악구',42,'T',sysdate);
INSERT INTO member (m_id, m_password, m_name, m_address, m_age, m_married, m_regdate) 
	VALUES ('xxxx','2222','김경우','서울시 강남구',34,'F',sysdate);
INSERT INTO member (m_id, m_password, m_name, m_address, m_age, m_married, m_regdate) 
	VALUES ('yyyy','3333','김경미','서울시 동작구',23,'F',sysdate);
	
--update pk
update member set m_password='1111',m_name='김변경',m_address='제주',m_age=28,m_married='F' where m_id='xxxx';
	
--delete pk
delete member where m_id='xxxx';

--select pk
select * from member where m_id='xxxx';
--select all
select * from member;
