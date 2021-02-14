DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE member CASCADE CONSTRAINTS;

CREATE TABLE member(
		m_id                          		VARCHAR2(10)		 NULL 		 PRIMARY KEY,
		m_password                    		VARCHAR2(10)		 NULL ,
		m_name                        		VARCHAR2(126)		 NULL ,
		m_address                     		VARCHAR2(255)		 NULL ,
		m_age                         		NUMBER(3)		 DEFAULT 0		 NULL ,
		m_married                     		CHAR(1)		 DEFAULT 'F'		 NULL ,
		m_regdate                     		DATE		 DEFAULT sysdate		 NULL 
);


CREATE TABLE board(
		b_no                          		NUMBER(10)		 NULL 		 PRIMARY KEY,
		b_title                       		VARCHAR2(150)		 NOT NULL,
		b_content                     		VARCHAR2(512)		 NOT NULL,
		b_date                        		DATE		 DEFAULT sysdate		 NULL ,
		m_id                          		VARCHAR2(10)		 NULL ,
  FOREIGN KEY (m_id) REFERENCES member (m_id)
);

DROP SEQUENCE board_b_no_SEQ;

CREATE SEQUENCE board_b_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;
/*
CREATE TRIGGER board_b_no_TRG
BEFORE INSERT ON board
FOR EACH ROW
BEGIN
IF :NEW.b_no IS NOT NULL THEN
  SELECT board_b_no_SEQ.NEXTVAL INTO :NEW.b_no FROM DUAL;
END IF;
END;
*/
