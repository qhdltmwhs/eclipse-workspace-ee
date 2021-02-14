--insert member
INSERT INTO member (m_id, m_password, m_name, m_address, m_age, m_married, m_regdate) 
	VALUES ('guard','1111','김경호','서울시 관악구',42,'T',sysdate);
INSERT INTO member (m_id, m_password, m_name, m_address, m_age, m_married, m_regdate) 
	VALUES ('xxxx','2222','김경우','서울시 강남구',34,'F',sysdate);
INSERT INTO member (m_id, m_password, m_name, m_address, m_age, m_married, m_regdate) 
	VALUES ('yyyy','3333','김경미','서울시 동작구',23,'F',sysdate);
--insert board
INSERT INTO board (b_no, b_title, b_content, b_date, m_id) 
VALUES (board_b_no_SEQ.nextval, '오늘은 금요일', '빨리 코로나가 ...', sysdate, 'guard');
INSERT INTO board (b_no, b_title, b_content, b_date, m_id) 
VALUES (board_b_no_SEQ.nextval, '오늘은 토요일', '잠자야겠다 ...', sysdate, 'guard');

INSERT INTO board (b_no, b_title, b_content, b_date, m_id) 
VALUES (board_b_no_SEQ.nextval, '오늘은 일요일', '잠이안와요 ...', sysdate, 'xxxx');
commit;
	
--update pk
update member set m_password='1111',m_name='김변경',m_address='제주',m_age=28,m_married='F' where m_id='xxxx';
	
--delete pk
delete member where m_id='xxxx';

--select pk
select * from member where m_id='xxxx';
--select all
select * from member;

--회원게시글목록

select *  from board where m_id='guard';
select *  from board where m_id='xxxx';

--회원게시글과 회원정보
select b.*,m.m_name from board b join member m on b.m_id=m.m_id where b.b_no=2;