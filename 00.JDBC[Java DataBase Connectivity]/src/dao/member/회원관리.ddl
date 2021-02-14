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


